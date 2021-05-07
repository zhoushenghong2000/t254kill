package com.zking.killprovider.model;

public class Goods {
    private Integer gid;

    private String gname;

    private Float gprice;

    private Integer gtype;

    private Integer gstatus;

    private Integer glib;

    public Goods(Integer gid, String gname, Float gprice, Integer gtype, Integer gstatus, Integer glib) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gtype = gtype;
        this.gstatus = gstatus;
        this.glib = glib;
    }

    public Goods() {
        super();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Float getGprice() {
        return gprice;
    }

    public void setGprice(Float gprice) {
        this.gprice = gprice;
    }

    public Integer getGtype() {
        return gtype;
    }

    public void setGtype(Integer gtype) {
        this.gtype = gtype;
    }

    public Integer getGstatus() {
        return gstatus;
    }

    public void setGstatus(Integer gstatus) {
        this.gstatus = gstatus;
    }

    public Integer getGlib() {
        return glib;
    }

    public void setGlib(Integer glib) {
        this.glib = glib;
    }
}