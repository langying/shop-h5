package com.mobei.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.BaseParam;
import com.mobei.app.service.MessageService;
import com.mobei.app.vo.ResultVo;

/**
 * 用户相关的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 系统信息列表
     *
     * @param param
     * @return
     */
    @RequestMapping("/list")
    public ResultVo list(BaseParam param) {
        ResultVo result = messageService.list(param);
        return result;
    }
}
