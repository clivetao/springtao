package com.clive.common.jwt;

import com.clive.user.entity.Admin;
import com.clive.user.entity.AdminUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATE_TIME="iat";

    /**
     *  <p>A common use case is to assign default field values using
     *  <code>#{systemProperties.myProp}</code> style expressions.
     */
    @Value("${jwt.key}")
    private  String key ;
    @Value("${jwt.expiration}")
    private  int expiration;

    public String generateToken(Map claims){
        return Jwts.builder()  // return new DefaultJwtBuilder();返回一个工具类来存储数据
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,key)
                .setExpiration(generateExpirationTime())
                .compact();
    }

    public String generateToken(UserDetails userDetails){
        String username = userDetails.getUsername();
        HashMap<Object, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,username);
        claims.put(CLAIM_KEY_CREATE_TIME,new Date());
        return generateToken(claims);
    }

    public Date generateExpirationTime(){
        return new Date(System.currentTimeMillis()+expiration);
    }


    private Claims getClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }


    public String getUsername(String token){
        Claims claimsFromToken = getClaimsFromToken(token);
        String username = claimsFromToken.getSubject();
        Date issuedAt = claimsFromToken.getIssuedAt();
        return username;
    }

    private boolean isExpirationTime(String token){
        Claims claimsFromToken = getClaimsFromToken(token);
        Date expiration = claimsFromToken.getExpiration();
        return  expiration.before(new Date());
    }

    public boolean isNeedRefresh(String token){
           return isExpirationTime(token);
    }

    public String refreshToken(String token){
            Claims claimsFromToken = getClaimsFromToken(token);
            claimsFromToken.put(CLAIM_KEY_CREATE_TIME,new Date());
            return generateToken(claimsFromToken);
    }

    public boolean validateUser(String token,UserDetails userDetails){
        String tokenUserName = getUsername(token);
        String localUserName = userDetails.getUsername();
        if (tokenUserName.equals(localUserName)){
            return true;
        }
        return false;
    }
}
