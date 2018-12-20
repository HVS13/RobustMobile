package com.haluancorp.robustmobile.Object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("totalRows")
    @Expose
    private Integer totalRows;
    @SerializedName("cmd")
    @Expose
    private String cmd;
    @SerializedName("cls")
    @Expose
    private String cls;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("nlist")
    @Expose
    private Integer nlist;
    @SerializedName("ncres")
    @Expose
    private Integer ncres;
    @SerializedName("dform0")
    @Expose
    private String dform0;
    @SerializedName("populate")
    @Expose
    private Boolean populate;
    @SerializedName("Cookie")
    @Expose
    private String cookie;


    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public int getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public int getNlist() {
        return nlist;
    }

    public void setNlist(Integer nlist) {
        this.nlist = nlist;
    }

    public int getNcres() {
        return ncres;
    }

    public void setNcres(Integer ncres) {
        this.ncres = ncres;
    }

    public String getDform0() {
        return dform0;
    }

    public void setDform0(String dform0) {
        this.dform0 = dform0;
    }

    public Boolean getPopulate() {
        return populate;
    }

    public void setPopulate(Boolean populate) {
        this.populate = populate;
    }
}
