package com.zking.killprovider.model;

public class TreeNode {
    private Integer tid;

    private String tname;

    private Integer tparent;

    private String url;

    private Integer position;

    private String icon;

    public TreeNode(Integer tid, String tname, Integer tparent, String url, Integer position, String icon) {
        this.tid = tid;
        this.tname = tname;
        this.tparent = tparent;
        this.url = url;
        this.position = position;
        this.icon = icon;
    }

    public TreeNode() {
        super();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTparent() {
        return tparent;
    }

    public void setTparent(Integer tparent) {
        this.tparent = tparent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}