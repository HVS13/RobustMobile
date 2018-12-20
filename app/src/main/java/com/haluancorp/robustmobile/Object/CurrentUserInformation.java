package com.haluancorp.robustmobile.Object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentUserInformation {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("config")
    @Expose
    private Configs config;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Configs getConfig() {
        return config;
    }

    public void setConfig(Configs config) {
        this.config = config;
    }

}