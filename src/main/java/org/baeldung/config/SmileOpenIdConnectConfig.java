package org.baeldung.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class SmileOpenIdConnectConfig {
    @Value("${smile.clientId}")
    private String clientId;

    @Value("${smile.accessTokenUri}")
    private String accessTokenUri;

    @Value("${smile.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${smile.redirectUri}")
    private String redirectUri;

    @Bean
    public OAuth2ProtectedResourceDetails smileOpenId() {
        final AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("openid","patient/*.read","patient/*.write"));
        details.setPreEstablishedRedirectUri(redirectUri);
        return details;
    }

    @Bean
    public OAuth2RestTemplate smileOpenIdTemplate(final OAuth2ClientContext clientContext) {
        final OAuth2RestTemplate template = new OAuth2RestTemplate(smileOpenId(), clientContext);
        return template;
    }

}
