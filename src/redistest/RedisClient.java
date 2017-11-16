package redistest;



import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class RedisClient {
    private static final String secret="test";
	public static void main(String[] args) throws Exception {
		System.out.println(createJWT("1","test",System.currentTimeMillis()));

	}
	public static SecretKey generalKey() throws Exception {
        byte[] encodedKey = decryptBASE64(encryptBASE64(secret.getBytes()));
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
		 private static final String privatekey="GmCL+M7jQXf/7dpJRxwQHkccJZjjCSKH+luPkllMqILr4tirK+LMe0OVSqO4GuGhEaweCV24JXRYCxdr+ABCnUPHyYP3j3T/evS4SA5pLo7Nht2XSaiO7Pi2LDH1+9mME4kvLDJ3hdFFwyeng84dPg5aSxGnSKT5oAU4BaXR+xeFiHOS9jZVyslxnDwi2igi0Z3g/gKgIghubYiKZg0KZzR35hNCcby3epUkK15wKN2nJ+l+nwEVBk3Rd+rTY/a1ZVD1sLRmplL64cawHe/xsVTOhGogvb3fBDDCrSeKvWm3BQhrN19vxUOZ4yuVOBxr5dJnrix/3ynMFjocGPun7Q==";
	    /** 
	     * BASE64解密 
	     *  
	     * @param key 
	     * @return 
	     * @throws Exception 
	     */  
	    public static byte[] decryptBASE64(String key) throws Exception {  
	        return (new BASE64Decoder()).decodeBuffer(key);  
	    }  
	  
	    /** 
	     * BASE64加密 
	     *  
	     * @param key 
	     * @return 
	     * @throws Exception 
	     */  
	    public static String encryptBASE64(byte[] key) throws Exception {  
	        return (new BASE64Encoder()).encodeBuffer(key).replace("\r", "").replace("\n", "");  
	    }
	/**
	  * 创建 jwt
	  * @param id
	  * @param subject
	  * @param ttlMillis
	  * @return
	  * @throws Exception
	  */
	  public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
	       SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
	       long nowMillis = System. currentTimeMillis();
	       Date now = new Date( nowMillis);
	       SecretKey key = generalKey();
	       JwtBuilder builder = Jwts. builder()
	            .setId(id)
	            .setIssuedAt(now)
	            .setSubject(subject)
	           .signWith(signatureAlgorithm, key);
	       if (ttlMillis >= 0){
	           long expMillis = nowMillis + ttlMillis;
	           Date exp = new Date( expMillis);
	           builder.setExpiration( exp);
	       }
	       return builder.compact();
	 }

	  /**
	  * 解密 jwt
	  * @param jwt
	  * @return
	  * @throws Exception
	  */
	  public static Claims parseJWT(String jwt) throws Exception{
	       SecretKey key = generalKey();
	       Claims claims = Jwts. parser()
	          .setSigningKey( key)
	          .parseClaimsJws( jwt).getBody();
	       return claims;
	 }
	
}
