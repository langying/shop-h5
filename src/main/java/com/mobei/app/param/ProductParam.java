package com.mobei.app.param;

/**
 * 系统通知接收参数实体bean定义
 *
 * @author lhl
 * @date 2018-08-10 下午 17:32
 */
public class ProductParam extends BaseParam {

    private int columnId;// 类型 默认为0：查所有 1：今日 2：热门推荐 3：优质推荐

    private int recommendFlag;// 0:不推荐 1：推荐

    private int hotFlag;

    private int loanType;// 0:金额不限 1.100-1000元 2：1001-5000 3.5001-10000 4.10001-50000

    private int borrowType;// 0:期限不限 1：1-30天 2：1-3个月 3：3-12个月 4：1-2年 5：2年以上

    private int productId;// 产品id

    private int messageId;// 通知id

    private int type;

    private String content;

    private String ipAddr;

    public int getHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(int hotFlag) {
        this.hotFlag = hotFlag;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public int getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(int recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    public int getLoanType() {
        return loanType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public int getBorrowType() {
        return borrowType;
    }

    public void setBorrowType(int borrowType) {
        this.borrowType = borrowType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
