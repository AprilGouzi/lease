package com.atguigu.lease.common.utils;

import com.atguigu.lease.common.exception.LeaseException;
import com.atguigu.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author 囍崽
 * version 1.0
 */
public class JwtUtil {

    private static long tokenExpiration = 60 * 60 * 1000 * 24 * 30L;
    private static SecretKey secretKey = Keys.hmacShaKeyFor("M0PKKI6pYGVWWfDZw90a0lTpGYX1d4AQ".getBytes());

    public static String createToken(Long userId, String username) {
        String token = Jwts.builder()
                .setSubject("USER_INFO")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .claim("username", username)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact(); //compact将其压缩成最终String形式。签名的JWT称为“JWS”。
        return token;
    }

    public static Claims parseToken(String token) {

        if (token == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try {
            JwtParser jwtParser = Jwts.parserBuilder()
                    .setSigningKey(secretKey) // 签名密钥
                    .build();
            return jwtParser.parseClaimsJwt(token) // 方法将传入的 token 进行解析
                    .getBody(); // 从jws对象中获取声明信息，返回一个claims对象
        } catch (ExpiredJwtException e) {
            // JWT验证异常，令牌无效
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            // JWT验证异常，令牌无效
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }

    public static void main(String[] args) {
        System.out.println(JwtUtil.createToken(2L, "user"));
    }

}