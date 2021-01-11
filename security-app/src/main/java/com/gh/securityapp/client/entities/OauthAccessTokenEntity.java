package com.gh.securityapp.client.entities;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "oauth_access_token", schema = "public", catalog = "security_app")
@FieldDefaults(makeFinal = false)
public class OauthAccessTokenEntity {
    private String tokenId;
    private byte[] token;
    private String authenticationId;
    private String userName;
    private String clientId;
    private byte[] authentication;
    private String refreshToken;

    @Basic
    @Column(name = "token_id")
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Basic
    @Column(name = "token")
    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    @Id
    @Column(name = "authentication_id")
    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "client_id")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "authentication")
    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Basic
    @Column(name = "refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OauthAccessTokenEntity that = (OauthAccessTokenEntity) o;
        return Objects.equals(tokenId, that.tokenId) && Arrays.equals(token, that.token) && Objects.equals(
                authenticationId,
                that.authenticationId) && Objects.equals(userName, that.userName) && Objects.equals(clientId,
                that.clientId) && Arrays.equals(authentication, that.authentication) && Objects.equals(refreshToken,
                that.refreshToken);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(tokenId, authenticationId, userName, clientId, refreshToken);
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
