package com.mobei.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.NewsParam;
import com.mobei.app.service.NewsService;
import com.mobei.app.vo.ResultVo;

/**
 * 产品栏目的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 产品列表的控制层定义
     *
     * @param param
     * @return
     */
    @RequestMapping("/list")
    public ResultVo list(NewsParam param) {
        ResultVo result = newsService.list(param);
        return result;
    }

    /**
     * 产品详情
     *
     * @param param
     * @return
     */
    @RequestMapping("/detail")
    public ResultVo detail(NewsParam param) {
        ResultVo result = newsService.detail(param);
        return result;
    }

}
