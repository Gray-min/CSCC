package com.zlzkj.app.model;

public class Goods {
    private Integer id;

    private String goodsId;

    private String function;

    private String picture;

    private String price;

    private String material;

    private String makingTime;

    private String productionTime;

    private String qualityGuarantee;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getMakingTime() {
        return makingTime;
    }

    public void setMakingTime(String makingTime) {
        this.makingTime = makingTime == null ? null : makingTime.trim();
    }

    public String getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(String productionTime) {
        this.productionTime = productionTime == null ? null : productionTime.trim();
    }

    public String getQualityGuarantee() {
        return qualityGuarantee;
    }

    public void setQualityGuarantee(String qualityGuarantee) {
        this.qualityGuarantee = qualityGuarantee == null ? null : qualityGuarantee.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}