package com.haluancorp.robustmobile.Object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("cmd")
    @Expose
    private String cmd;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("Set-Cookie")
    @Expose
    private String SetCookie;

    public String getSetCookie() {
        return SetCookie;
    }

    public void setSetCookie(String setCookie) {
        SetCookie = setCookie;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}