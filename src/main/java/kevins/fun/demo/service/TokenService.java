package kevins.fun.demo.service;

import com.google.common.collect.ImmutableMap;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.compression.GzipCompressionCodec;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static io.jsonwebtoken.impl.TextCodec.BASE64;

@Service
//@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokenService implements Clock {
    private static final GzipCompressionCodec COMPRESSION_CODEC = new GzipCompressionCodec();

    String issuer;
    String secretKey;

    TokenService() {
        super();
        this.issuer = "info world";
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! issuer " + issuer);
        this.secretKey = BASE64.encode("www.infoworld.com");
    }

    public String newToken(final Map<String, String> attributes) {
        final Date now = new Date();
        final Claims claims = Jwts.claims().setIssuer(issuer).setIssuedAt(now);

        claims.putAll(attributes);

        return Jwts.builder().setClaims(claims).signWith(HS256, secretKey).compressWith(COMPRESSION_CODEC)
                .compact();
    }

    public Map<String, String> verify(final String token) {
        final JwtParser parser = Jwts.parser().requireIssuer(issuer).setClock(this).setSigningKey(secretKey);
        return parseClaims(() -> parser.parseClaimsJws(token).getBody());
    }

    private static Map<String, String> parseClaims(final Supplier<Claims> toClaims) {
        try {
            final Claims claims = toClaims.get();
            final ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
            for (final Map.Entry<String, Object> e: claims.entrySet()) {
                builder.put(e.getKey(), String.valueOf(e.getValue()));
            }
            return builder.build();
        } catch (final IllegalArgumentException | JwtException e) {
            return ImmutableMap.of();
        }
    }

    @Override
    public Date now() {
        return new Date();
    }
}
