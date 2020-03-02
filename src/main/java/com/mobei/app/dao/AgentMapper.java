package com.mobei.app.dao;

import com.mobei.app.entity.AgentEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 第三方链接的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface AgentMapper {


    /**
     * 分页查询列表
     *
     * @return
     */
    AgentEntity findByCode(String code);


    /**添加打开记录*/
    int save(@Param("agentId") int agentId, @Param("ipAddr") String ipAddr);


}
