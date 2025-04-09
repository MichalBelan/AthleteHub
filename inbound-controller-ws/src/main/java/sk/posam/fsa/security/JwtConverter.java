package sk.posam.fsa.security;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtConverter {

    public String getUserId(Jwt jwt) {
        return jwt.getSubject();
    }

    public String getEmail(Jwt jwt) {
        return jwt.getClaimAsString("email");
    }

    public String getRole(Jwt jwt) {
        return jwt.getClaimAsString("role");
    }
}
