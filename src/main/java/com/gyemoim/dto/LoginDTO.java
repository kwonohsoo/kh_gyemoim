package com.gyemoim.dto;

public class LoginDTO {

    private String email;
    private String password;
    private boolean useCookie;

    /////////////////////////// 확인필요
//    private String sessionKey;
//    private Date sessionLimit;
/////////////////////////////////////////////
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUseCookie() {return useCookie;}

    public void setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
    }

    @Override
    public String toString() {
        return "LoginDTO [email=" + email + ", password=" + password + ", useCookie="
                + useCookie + "]";
    }

    
    ////////////////////////////////////  확인 필요
//    public String getSessionKey() {
//        return sessionKey;
//    }
//    public void setSessionKey(String sessionKey) {
//        this.sessionKey = sessionKey;
//    }
}
