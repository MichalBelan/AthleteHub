//package sk.posam.fsa.security;
//
//import com.nimbusds.jwt.JWT;
//import com.nimbusds.jwt.JWTParser;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//
//import java.text.ParseException;
//import java.util.Map;
//
//@Configuration
//public class JwtDecoderConfiguration {
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return token -> {
//            try {
//                JWT nimbusJwt = JWTParser.parse(token);
//                String tokenValue = nimbusJwt.serialize();
//                Map<String, Object> headers = nimbusJwt.getHeader().toJSONObject();
//                Map<String, Object> claims = nimbusJwt.getJWTClaimsSet().getClaims();
//                return new Jwt(
//                        tokenValue,
//                        nimbusJwt.getJWTClaimsSet().getIssueTime().toInstant(),
//                        nimbusJwt.getJWTClaimsSet().getExpirationTime().toInstant(),
//                        headers,
//                        claims
//                );
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        };
//    }
//}

package sk.posam.fsa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class JwtDecoderConfiguration {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}
