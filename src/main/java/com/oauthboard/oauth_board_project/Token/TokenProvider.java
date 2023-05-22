package com.oauthboard.oauth_board_project.Token;


import com.nimbusds.oauth2.sdk.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Log4j2
public class TokenProvider {




}
