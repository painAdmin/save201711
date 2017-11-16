package test01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Service {

	private Selector selector;
	private int count;
	public void initService(int port) throws IOException{
		ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
		   serverSocketChannel.configureBlocking(false);
		   serverSocketChannel.bind(new InetSocketAddress(port));
		   this.selector=Selector.open();
		 serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	public void listen() throws IOException{
		System.out.println("服务端已经启动！");
		while(true){
			selector.select();
			Iterator ite=this.selector.selectedKeys().iterator();
			while(ite.hasNext()){
				SelectionKey key=(SelectionKey)ite.next();
				ite.remove();
				if(key.isAcceptable()){
					ServerSocketChannel ssChannel=(ServerSocketChannel)key.channel();
					SocketChannel socketChannel=ssChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.write(ByteBuffer.wrap(new String("服务端------向客户端！").getBytes()));
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
		ByteBuffer buff=ByteBuffer.allocate(100*1024);
		socketChannel.read(buff);
		byte[] data=buff.array();
		String msg=new String(data);
		System.out.println("收到CC客户端的消息："+msg);
		ByteBuffer outBuff=ByteBuffer.wrap(new String(msg).getBytes());
		 socketChannel.write(outBuff);
	}
	public static void main(String[] args) throws IOException{
		Service service=new Service();
		service.initService(7979);
		service.listen();
	}
}









