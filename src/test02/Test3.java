package test02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test3 {
    public static final String[] hexDigits=new String[]{"0", "1", "2", "3", "4",  
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
	public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, IOException{
		String file="F:\\安装包\\虚拟机\\cn_windows_7_ultimate_with_sp1_x86_dvd_618763.iso";
		int bufferSize=256*1024;
		FileInputStream fileInputStream=null;
		DigestInputStream digestInputStream=null;
		try{
			MessageDigest messageDigest=MessageDigest.getInstance("MD5");
			
			fileInputStream=new FileInputStream(file);
			digestInputStream=new DigestInputStream(fileInputStream,messageDigest);
			
			byte[] buffer=new byte[bufferSize];
			
			while(digestInputStream.read(buffer)>0);
			messageDigest=digestInputStream.getMessageDigest();
			
			byte[] resultByteArray=messageDigest.digest();
			
			String res= byteArrayToHex(resultByteArray);
			System.out.println(res);
		}catch(Exception e){
			
		}finally{
			if(digestInputStream!=null){
				digestInputStream.close();
			}
			
		}
	}
	public static String byteArrayToHex(byte[] result){
		StringBuffer sp=new StringBuffer();
		for(int i=0;i<result.length;i++){
			sp.append(byteToHexString(result[i]));
		}
		return sp.toString();
	}
	public static String byteToHexString(byte b){
		int n=b;
		if(n<0){
			n=256+n;
		}
		int b1=n/16;
		int b2=n%16;
		return hexDigits[b1]+hexDigits[b2];
	}
}

















