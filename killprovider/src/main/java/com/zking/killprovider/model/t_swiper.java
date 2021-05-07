package com.zking.killprovider.model;

public class t_swiper {
    private Integer id;

    private Integer goodsId;

    private String openType;

    private String imageSrc;

    private String navigatorUrl;

    public t_swiper(Integer id, Integer goodsId, String openType, String imageSrc, String navigatorUrl) {
        this.id = id;
        this.goodsId = goodsId;
        this.openType = openType;
        this.imageSrc = imageSrc;
        this.navigatorUrl = navigatorUrl;
    }

    public t_swiper() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getNavigatorUrl() {
        return navigatorUrl;
    }

    public void setNavigatorUrl(String navigatorUrl) {
        this.navigatorUrl = navigatorUrl;
    }
}