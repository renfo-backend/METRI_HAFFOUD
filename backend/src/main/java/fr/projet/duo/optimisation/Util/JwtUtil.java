package fr.projet.duo.optimisation.Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    // Utiliser la clé secrète aléatoire générée
    private static final String SECRET_KEY_STRING = "5fGv6txW7yLP1X3NpQZ09lUmHuTrsWVJc3y0x9RfKbXYMbD4sPqz65KtFbOwL2Xp";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 heure

    public static String generateToken(Long userId, String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("userId", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public static Long extractUserId(String token) {
        return extractClaims(token).get("userId", Long.class);
    }

    public static Claims extractClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
    }

    public static boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private static boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
