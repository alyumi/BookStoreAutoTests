package api.ValueObject.Model;

import java.util.Date;

public class LoginModel {
    private String userId;
    private String username;
    private String password;
    private String token;
    private Date expires;
    private Date created_date;
    private boolean isActive;

    public LoginModel() {
    }

    public LoginModel(String userId, String username, String password, String token, Date expires, Date created_date, boolean isActive) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.token = token;
        this.expires = expires;
        this.created_date = created_date;
        this.isActive = isActive;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public Date getExpires() {
        return expires;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
