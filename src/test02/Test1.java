package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
//		Socket s = new Socket();
//		SocketAddress add = new InetSocketAddress("127.0.0.1",8080);
//		try {
//			s.connect(add,5000);
//			System.out.println("连接正常");
//			s.close();
//		} catch (IOException e) {
//			System.out.println("连接异常");
//			e.printStackTrace();
//		}
		long time1=System.currentTimeMillis();
		List<String> list=new ArrayList<String>();
		List<String[]> templist=new ArrayList<String[]>();
		Runtime run=Runtime.getRuntime();
		try {
			String cmd="cmd /c netstat -an |find \"0.0.0.0:3389\" |find \"LISTENING\"";
			String cmd1="cmd /c netstat -an";
			
			Process process=run.exec(cmd);
		
			BufferedReader br=new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
			String line=null;
			while((line=br.readLine())!=null){
			   System.out.println(line);
			   
			}
			
			
			
			if(br!=null){
				br.close();
			}
		long time2=System.currentTimeMillis();
		System.out.println("耗时："+(time2-time1));
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally{
			
		}
		

	}
  public static void  test(){
	    String regex1="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
		             +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
		             +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
		             +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$;";
	    String regex2="\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}|0";;
        String ip="0";
        String[]  ips=ip.split("\\.");
        System.out.println(ip.matches(regex2));
		System.out.println(System.currentTimeMillis());
  }
  public static void test1(){
//		for (Enumeration e =request.getParameterNames(); e.hasMoreElements();){
//		String str=(String)e.nextElement();
//		if(!str.equals("url"))	
//	       	para+="&"+str+"="+request.getParameter(str);
//	      
//	      
//	}
	  Runtime run=Runtime.getRuntime();
		 try {
			Process process= run.exec("");
			InputStream in=process.getInputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
  }
}
class MyEnumerator implements Enumeration{

	 int count ;
	 int length;
	 Object[] dataArray;
	 MyEnumerator(int count,int length,Object[] dataArray){
		 this.count=count;
		 this.length=length;
		 this.dataArray=dataArray;
	 }
	@Override
	public boolean hasMoreElements() {
	     
		return count<length;
	}

	@Override
	public Object nextElement() {
	
		return dataArray[count++];
	}
	 
}

class MyDataStruct{
	private String[] data;
	public MyDataStruct(){
		 data=new String[4];
		 data[0]="ZERO";
		 data[1]="One";
		 data[2]="two";
		 data[3]="three";
	 }
	 Enumeration getEnum(){
		 return new MyEnumerator(0,data.length,data);
	 }
}
