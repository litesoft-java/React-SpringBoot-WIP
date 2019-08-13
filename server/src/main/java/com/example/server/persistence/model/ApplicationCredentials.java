package com.example.server.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ApplicationCredentials {
    @GeneratedValue
    @Id
    private Long id;
    private String userId;
    private String applicationName;
    private String encryptedUserName;
    private String encryptedPassword;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public void setEncryptedUserName(String encryptedUserName) {
        this.encryptedUserName = encryptedUserName;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEncryptedUserName() {
        return encryptedUserName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public ApplicationCredentials withId(Long id) {
        this.id = id;
        return this;
    }

    public ApplicationCredentials withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public ApplicationCredentials withApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }

    public ApplicationCredentials withEncryptedUserName(String encryptedUserName) {
        this.encryptedUserName = encryptedUserName;
        return this;
    }

    public ApplicationCredentials withEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationCredentials that = (ApplicationCredentials) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ApplicationCredentials{" +
                "id=" + id +
                ", userId='" + userId + "'" +
                ", applicationName='" + applicationName + '\'' +
                ", encryptedUserName='" + encryptedUserName + '\'' +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                '}';
    }
}
