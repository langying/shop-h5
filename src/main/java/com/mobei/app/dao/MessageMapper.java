package com.mobei.app.dao;

import com.mobei.app.entity.MessageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统消息的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface MessageMapper {


    /**
     * 分页查询列表
     *
     * @return
     */
    List<MessageEntity> list();

    /**根据用户id查询通知列表*/
    List<MessageEntity> findList(@Param("userId") int userId);


    /**添加查看记录*/
    int saveLook(@Param("userId") int userId,@Param("messageId") int messageId);

    /**查询是否已经添加过记录*/
    MessageEntity isLook(@Param("userId") int userId,@Param("messageId") int messageId);
}
