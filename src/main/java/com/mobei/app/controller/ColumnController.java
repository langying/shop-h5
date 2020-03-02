package com.mobei.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.ColumnParam;
import com.mobei.app.service.ColumnService;
import com.mobei.app.vo.ResultVo;

/**
 * 产品栏目的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    /**
     * 产品列表的控制层定义
     *
     * @param param
     * @return
     */
    @RequestMapping("/list")
    public ResultVo list(ColumnParam param) {
        ResultVo result = columnService.list(param);
        return result;
    }

}
