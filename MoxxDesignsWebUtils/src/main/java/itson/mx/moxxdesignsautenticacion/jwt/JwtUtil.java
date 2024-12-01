/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsautenticacion.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import itson.mx.moxxdesignsexcepciones.AutenticacionException;
import jakarta.servlet.http.Cookie;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author olive
 */
public class JwtUtil {

    private static final String SECRET_KEY = "ypuroscorridostumbadospatrinoyatelasabeseaaa";
    private static final long EXPIRATION_TIME = 10800000;

    // Método para generar un JWT
    public static String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    // Método para validar un JWT y obtener el usuario
    public static String getTokenData(String token) throws AutenticacionException {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            throw new AutenticacionException("Autenticacion de Usuario no Valida") ;
        }
    }
    
    public static String getTokenFromCookies(Cookie[] cookies) {
            String token = null;

            if (cookies != null) {
                // Buscar la cookie llamada "auth_token"
                for (Cookie cookie : cookies) {
                    if ("auth_token".equals(cookie.getName())) {
                        token = cookie.getValue();
                        break;
                    }
                }
            }
            
            return token ;
    }
    
    public static boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true; // Token válido
        } catch (Exception e) {
            return false; // Token inválido o expirado
        }
    }

    private static Key getSigningKey() {
        byte[] secretBytes = Base64.getDecoder().decode(SECRET_KEY);
        return new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName());
    }
}

