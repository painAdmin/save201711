package test01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {

	private Selector selector;
	private int count=0;
	
	public void initClient(String ip,int port) throws IOException{
		System.out.println("客户端已经启动！");
		SocketChannel socketChannel=SocketChannel.open();
		socketChannel.configureBlocking(false);
		this.selector=Selector.open();
		socketChannel.connect(new InetSocketAddress(ip,port));
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		
	}
	public void listen() throws IOException{
		while(true){
			selector.select();
			Iterator ite=this.selector.selectedKeys().iterator();
			while(ite.hasNext()){
				SelectionKey key=(SelectionKey)ite.next();
				ite.remove();
				if(key.isConnectable()){
					SocketChannel socketChannel=(SocketChannel)key.channel();
					if(socketChannel.isConnectionPending()){
						socketChannel.finishConnect();
					}
					socketChannel.configureBlocking(false);
					socketChannel.write(ByteBuffer.wrap(new String("客户端----向服务端").getBytes()));
					
					socketChannel.register(selector, SelectionKey.OP_READ);
					count++;
				}else if(key.isReadable()){
					read(key);
					count++;
				}
				
			}
			if(count>=7){
				break;
			}
			
		}
		
	}
	@SuppressWarnings("unchecked")
	public void read(SelectionKey key) throws IOException{
		SocketChannel socketChannel=(SocketChannel)key.channel();
		ByteBuffer buff=ByteBuffer.allocate(10*1024);
		socketChannel.read(buff);
		byte[] data=buff.array();
		String msg=new String(data);
		System.out.println("SS接收服务端的消息::"+msg);
		socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
	}
	public static void main(String[] args) throws IOException{
		Client client=new Client();
		client.initClient("localhost", 7979);
		client.listen();
	}
	
}

































