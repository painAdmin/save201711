package test03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test03 {

	public static void main(String[] args) throws Exception {
//		  String path="F:\\test";
//		  System.out.println(path.replaceAll("\\\\", "\\\\\\\\"));
		 Thread t=new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true){
					Date date=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println(sdf.format(date));
					try {
						Thread.sleep(1000L);
					} catch (InterruptedException e) {		
						e.printStackTrace();
					}
				}
				
				
			}
			 
		 });
		 t.start();
	}
	 public static byte[] HexString2Bytes(String hexstr) {
	        byte[] b = new byte[hexstr.length() / 2];
	        int j = 0;
	        for (int i = 0; i < b.length; i++) {
	            char c0 = hexstr.charAt(j++);
	            char c1 = hexstr.charAt(j++);
	            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
	        }
	        return b;
	 }
	 private static int parse(char c) {
	        if (c >= 'a') return (c - 'a' + 10) & 0x0f;
	        if (c >= 'A') return (c - 'A' + 10) & 0x0f;
	        return (c - '0') & 0x0f;
	 }

	
}
