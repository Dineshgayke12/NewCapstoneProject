package com.in.User.com.in.User.Securirt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Compoent
public class JwtTockenHelper {

//    public String final long JWT_TOKEN_VALIDITY=5*60*60;
//
//    private String secret="JwtTokenKey";
//
//    public String getUSerNameFromToken(String token){
//        return  getClaimFromtken(token , Claims::getSubject);
//    }
//
//    public Date getExpirationDateFromToken(String token){
//        return getClaimFromtken(token , Claims::getExpiration);
//    }
//
//
//    public <T> getClaimFromtken(String token, Fuction<Claims, T> claimsResolver){
//        final  Claims claims=getAllClaimsFromToken(token);
//        return; claimsResolver.apply(claims);
//    }
//
//    public  Boolean getAllClaimsFromToken(String token){
//        final Date ecpiration=getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUsername());
//    }
//
//    public String doGenerateToken(Map<String, Object>){
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.)).setExpiration(SignatureAlgorithm.HS512, secret).Compact();
//    }


}
