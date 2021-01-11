package com.gh.securityapp.client.entities;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "oauth_refresh_token", schema = "public", catalog = "security_app")
@FieldDefaults(makeFinal = false)
public class OauthRefreshTokenEntity {
    private String tokenId;
    private byte[] token;
    private byte[] authentication;

    @Id
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

    @Basic
    @Column(name = "authentication")
    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OauthRefreshTokenEntity that = (OauthRefreshTokenEntity) o;
        return Objects.equals(tokenId, that.tokenId) && Arrays.equals(token,
                that.token) && Arrays.equals(authentication, that.authentication);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(tokenId);
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
