package com.gh.securityapp.client.entities;

import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "oauth_code", schema = "public", catalog = "security_app")
@FieldDefaults(makeFinal = false)
public class OauthCodeEntity {
    private String code;
    private byte[] authentication;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        OauthCodeEntity that = (OauthCodeEntity) o;
        return Objects.equals(code, that.code) && Arrays.equals(authentication, that.authentication);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(code);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
