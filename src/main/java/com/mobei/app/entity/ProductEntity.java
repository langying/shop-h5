package com.mobei.app.entity;

import com.mobei.common.entity.BaseEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-07-31 下午 18:02
 *
 * 平台商品实体bean定义
 */
public class ProductEntity extends BaseEntity{

    /**
     * 产品名称
     */
    private String name;

    /**
     * logo地址
     */
    private String imgUrl;

    /**
     * 最低贷款金额
     */
    private Integer loanAmountMin;

    /**
     * 贷款金额最高
     */
    private Integer loanAmountMax;

    /**
     * 放款时间
     */
    private String payTime;

    /**
     * 默认为：1 今日贷款   2：热门推荐  3：优质推荐
     */
    private Integer type;

    /**
     * 推荐标识  0:不推荐  1：推荐
     *
     * */
    private Integer recommendFlag;

    private Integer hotFlag;


    /**
     * 申请条件   json数据
     */
    private String applyData;

    /**
     * 产品特色   json数据
     *
     * */
    private String featuresData;

    /**
     * 贷款利率  %
     */
    private Double rateScope;

    /**
     * 利率单位
     */
    private String rateUnit;

    /**
     * 最低借款期限
     */
    private Integer borrowMin;

    /**
     * 最高借款期限
     *
     * */
    private Integer borrowMax;

    /**
     * 借款期限单位  1:天  2：月  3：年
     * */
    private Integer borrowUnit;

    /**
     * 排序值 越大越前面
     */
    private Integer orderNum;

    /**
     * 第三方链接地址
     */
    private String linkUrl;

    /**
     * 申请总人数
     */
    private Integer applyTotal;


    /**
     * 标签
     *
     * */
    private String labels;

    /**产品id*/
    private int productId;


    /**评分等级*/
    private Integer score;//0-5


    /**申请记录时间*/
    private String applyTime;

    private String introduce;//产品介绍

    private String describe;//产品描述

    public Integer getHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(Integer hotFlag) {
        this.hotFlag = hotFlag;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(Integer loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public Integer getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(Integer loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(Integer recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    public String getApplyData() {
        return applyData;
    }

    public void setApplyData(String applyData) {
        this.applyData = applyData;
    }

    public String getFeaturesData() {
        return featuresData;
    }

    public void setFeaturesData(String featuresData) {
        this.featuresData = featuresData;
    }

    public Double getRateScope() {
        return rateScope;
    }

    public void setRateScope(Double rateScope) {
        this.rateScope = rateScope;
    }

    public String getRateUnit() {
        return rateUnit;
    }

    public void setRateUnit(String rateUnit) {
        this.rateUnit = rateUnit;
    }

    public Integer getBorrowMin() {
        return borrowMin;
    }

    public void setBorrowMin(Integer borrowMin) {
        this.borrowMin = borrowMin;
    }

    public Integer getBorrowMax() {
        return borrowMax;
    }

    public void setBorrowMax(Integer borrowMax) {
        this.borrowMax = borrowMax;
    }

    public Integer getBorrowUnit() {
        return borrowUnit;
    }

    public void setBorrowUnit(Integer borrowUnit) {
        this.borrowUnit = borrowUnit;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getApplyTotal() {
        return applyTotal;
    }

    public void setApplyTotal(Integer applyTotal) {
        this.applyTotal = applyTotal;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
