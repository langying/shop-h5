package com.mobei.app.param;

/**
 * (描述用途)
 *
 * @author Sum
 * @date 2018-08-26 下午 16:33
 */
public class AgentParam extends BaseParam{

    private int agentId;//通知id

    private String ipAddr;//ip地址

    private String sign;

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
}
