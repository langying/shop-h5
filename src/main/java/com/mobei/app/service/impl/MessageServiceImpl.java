package com.mobei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mobei.app.dao.MessageMapper;
import com.mobei.app.dao.UserMapper;
import com.mobei.app.entity.MessageEntity;
import com.mobei.app.entity.UserEntity;
import com.mobei.app.param.BaseParam;
import com.mobei.app.service.MessageService;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.PageVo;
import com.mobei.app.vo.ResultVo;

/**
 * 系统通知的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public ResultVo list(BaseParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<MessageEntity> list = null;
            if (param.getToken() != null) {
                UserEntity user = userMapper.findByToken(param.getToken());// 查询用户信息
                if (user != null) {
                    list = messageMapper.findList(user.getUserId());
                }
                else {
                    list = messageMapper.list();
                }
            }
            else {
                list = messageMapper.list();
            }
            PageVo<MessageEntity> pageInfo = new PageVo<>(list);
            result.setData(pageInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;

    }
}
