package com.haluancorp.robustmobile.Object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configs {

    @SerializedName("applicatioName")
    @Expose
    private String applicatioName;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("userlogo")
    @Expose
    private String userlogo;
    @SerializedName("defaultuserlogo")
    @Expose
    private String defaultuserlogo;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("estate")
    @Expose
    private String estate;
    @SerializedName("factory")
    @Expose
    private String factory;
    @SerializedName("companylogo")
    @Expose
    private String companylogo;
    @SerializedName("defaultcompanylogo")
    @Expose
    private String defaultcompanylogo;
    @SerializedName("userWidgetConfig")
    @Expose
    private Object userWidgetConfig;
    @SerializedName("userThemes")
    @Expose
    private String userThemes;
    @SerializedName("userLanguage")
    @Expose
    private String userLanguage;
    @SerializedName("filePictureSizeMax")
    @Expose
    private String filePictureSizeMax;
    @SerializedName("fileCsvSizeMax")
    @Expose
    private String fileCsvSizeMax;
    @SerializedName("newsTicker")
    @Expose
    private String newsTicker;
    @SerializedName("sessioncheckinterval")
    @Expose
    private Integer sessioncheckinterval;

    public String getApplicatioName() {
        return applicatioName;
    }

    public void setApplicatioName(String applicatioName) {
        this.applicatioName = applicatioName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserlogo() {
        return userlogo;
    }

    public void setUserlogo(String userlogo) {
        this.userlogo = userlogo;
    }

    public String getDefaultuserlogo() {
        return defaultuserlogo;
    }

    public void setDefaultuserlogo(String defaultuserlogo) {
        this.defaultuserlogo = defaultuserlogo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public String getDefaultcompanylogo() {
        return defaultcompanylogo;
    }

    public void setDefaultcompanylogo(String defaultcompanylogo) {
        this.defaultcompanylogo = defaultcompanylogo;
    }

    public Object getUserWidgetConfig() {
        return userWidgetConfig;
    }

    public void setUserWidgetConfig(Object userWidgetConfig) {
        this.userWidgetConfig = userWidgetConfig;
    }

    public String getUserThemes() {
        return userThemes;
    }

    public void setUserThemes(String userThemes) {
        this.userThemes = userThemes;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getFilePictureSizeMax() {
        return filePictureSizeMax;
    }

    public void setFilePictureSizeMax(String filePictureSizeMax) {
        this.filePictureSizeMax = filePictureSizeMax;
    }

    public String getFileCsvSizeMax() {
        return fileCsvSizeMax;
    }

    public void setFileCsvSizeMax(String fileCsvSizeMax) {
        this.fileCsvSizeMax = fileCsvSizeMax;
    }

    public String getNewsTicker() {
        return newsTicker;
    }

    public void setNewsTicker(String newsTicker) {
        this.newsTicker = newsTicker;
    }

    public Integer getSessioncheckinterval() {
        return sessioncheckinterval;
    }

    public void setSessioncheckinterval(Integer sessioncheckinterval) {
        this.sessioncheckinterval = sessioncheckinterval;
    }

}