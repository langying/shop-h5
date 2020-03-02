package com.mobei.app.entity;

import com.mobei.common.entity.BaseEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-07-31 下午 18:02
 *
 * 产品浏览记录
 */
public class ProductBrowseEntity extends BaseEntity{

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
     * 第三方链接地址
     */
    private String linkUrl;

    /**产品介绍*/
    private String introduce;

    /**产品描述*/
    private String describe;


    /**产品id*/
    private int productId;

    /**浏览时间*/
    private String days;

    private String ipAddr;//ip地址

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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



    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }



}
