package test02;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;

import javax.crypto.Cipher;


public class Test4 {

	private String data="admin123!";
	public static void main(String[] args){
		
	}
	public String getEncodeData(String publicKey,String data){
		
		return null;
	}
	

	
	
	
	public void isCRC(){
		String str="1121";
		CRC32 crc=new CRC32();
		crc.update(str.getBytes());
		System.out.println(crc.getValue());
	}
}
