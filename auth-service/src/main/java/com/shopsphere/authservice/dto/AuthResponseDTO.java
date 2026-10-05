package com.shopsphere.authservice.dto;

public class AuthResponseDTO {

    private String token;
    private String tokenType;
    private Long userId;
    private String userName;
    private String role;

    public AuthResponseDTO() {


    }

    public AuthResponseDTO(String token,
                           String tokenType,
                           Long Id,
                           String userName,
                           String role) {
        this.role = role;
        this.token = token;
        this.tokenType = tokenType;
        this.userId = Id;
        this.userName = userName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
