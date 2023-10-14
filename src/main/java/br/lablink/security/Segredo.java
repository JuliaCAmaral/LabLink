package br.lablink.security;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public class Segredo {
    public static final SecretKey CHAVE_SECRETA = Keys.hmacShaKeyFor("Ac!5Ef!KjbW*HJ7SMS@8uAiVf6oTHLAXjF!5i8!FeK&&Fx6G"
            .getBytes(StandardCharsets.UTF_8));

}
