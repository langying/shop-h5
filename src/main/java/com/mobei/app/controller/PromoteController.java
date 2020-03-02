package com.mobei.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.BaseParam;
import com.mobei.app.service.PromoteService;
import com.mobei.app.vo.ResultVo;

/**
 * 轮播图的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/promote")
public class PromoteController {

    @Autowired
    private PromoteService promoteService;

    /**
     * 推广位的控制层定义
     *
     * @param param
     * @return
     */
    @RequestMapping("/list")
    public ResultVo list(BaseParam param) {
        ResultVo result = promoteService.list(param);
        return result;
    }

}
