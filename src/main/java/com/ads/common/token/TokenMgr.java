package com.ads.common.token;

import com.ads.Constant;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * Token 管理
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/18
 */
public class TokenMgr {
    
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(Constant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    
    /**
     * 签发JWT
     * @param subject
     * @return
     * @throws Base64DecodingException
     */
    public static String createJWT(String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(signatureAlgorithm, secretKey)
                .compact();
    }
    
    public static Jws<Claims> validateJWT(String jwtStr) {
        SecretKey secretKey = generalKey();
        
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtStr);
    }
    
    public static void main(String[] args) {
        String jwt = TokenMgr.createJWT("123456");
        System.out.println(jwt);
        Jws<Claims> jws = TokenMgr.validateJWT(jwt);
        jws.getBody();
        System.out.println(jws.getBody().getSubject());
    }
}
