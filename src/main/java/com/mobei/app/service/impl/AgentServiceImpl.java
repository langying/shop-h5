package com.mobei.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobei.app.dao.AgentMapper;
import com.mobei.app.entity.AgentEntity;
import com.mobei.app.param.AgentParam;
import com.mobei.app.service.AgentService;

/**
 * 轮播图的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("agentService")
public class AgentServiceImpl implements AgentService {

    @Resource
    private AgentMapper agentMapper;

    @Override
    public String link(AgentParam param) {
        String result = null;
        try {
            AgentEntity agent = agentMapper.findByCode(param.getSign());
            if (agent != null) {
                result = agent.getLinkUrl() + "?uid=" + param.getSign();
                agentMapper.save(agent.getId(), param.getIpAddr());// 添加记录
            }
        }
        catch (Exception e) {
            return result;
        }
        return result;
    }
}
