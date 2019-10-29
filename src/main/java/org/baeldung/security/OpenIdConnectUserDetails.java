package org.baeldung.security;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OpenIdConnectUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private OAuth2AccessToken token;

    public OpenIdConnectUserDetails(Map<String, String> userInfo, OAuth2AccessToken token) {
        this.userId = userInfo.get("sub");
        this.username = userInfo.get("sub");
        this.token = token;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public OAuth2AccessToken getToken() {
        return token;
    }

    public void setToken(OAuth2AccessToken token) {
        this.token = token;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
