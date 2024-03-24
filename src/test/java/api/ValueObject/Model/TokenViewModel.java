package api.ValueObject.Model;

import java.util.Date;

public class TokenViewModel {
    private String token;
    private Date expires;
    private String status;
    private String result;

    public TokenViewModel() {
    }

    public TokenViewModel(String token, Date expires, String status, String result) {
        this.token = token;
        this.expires = expires;
        this.status = status;
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public Date getExpires() {
        return expires;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }
}
