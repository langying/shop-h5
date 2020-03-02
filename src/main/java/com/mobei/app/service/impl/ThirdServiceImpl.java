package com.mobei.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobei.app.dao.MessageMapper;
import com.mobei.app.dao.ThirdMapper;
import com.mobei.app.dao.UserMapper;
import com.mobei.app.entity.MessageEntity;
import com.mobei.app.entity.ThirdEntity;
import com.mobei.app.entity.UserEntity;
import com.mobei.app.param.ThirdParam;
import com.mobei.app.service.ThirdService;
import com.mobei.common.jpush.InitJiGuangConfig;

/**
 * 轮播图的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("thirdService")
public class ThirdServiceImpl implements ThirdService {

    @Resource
    private ThirdMapper thirdMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private MessageMapper messageMapper;

    @Override
    public String link(ThirdParam param) {
        ThirdEntity third = thirdMapper.findByCode(param.getSign());
        String result = null;
        UserEntity user = null;
        if (third.getType() == 1) {
            result = InitJiGuangConfig.PRODUCT_DETAIL + "?productId=" + third.getProductId();
        }
        else {
            if (third != null) {
                user = userMapper.findByToken(param.getToken());// 查询用户信息
                if (user != null) {
                    thirdMapper.saveApply(user.getUserId(), third.getId(), param.getIpAddr());// 添加申请记录
                }
                else {
                    thirdMapper.saveApply(0, third.getId(), param.getIpAddr());// 添加申请记录
                }
                thirdMapper.updateTotal(third.getId());// 添加申请人数
            }
            result = third.getLinkUrl();
        }
        try {// 添加查看记录
            if (param.getMessageId() > 0 && param.getToken() != null) {
                user = userMapper.findByToken(param.getToken());// 查询用户信息
                MessageEntity message = messageMapper.isLook(user.getUserId(), param.getMessageId());// 查询是否已经观看
                if (message == null) {
                    if (user != null) {
                        messageMapper.saveLook(user.getUserId(), param.getMessageId());// 添加记录
                    }
                    else {
                        messageMapper.saveLook(0, param.getMessageId());// 添加记录
                    }

                }
            }

        }
        catch (Exception e) {
            return result;
        }

        return result;
    }
}
