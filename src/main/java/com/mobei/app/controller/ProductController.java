package com.mobei.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.ProductParam;
import com.mobei.app.service.ProductService;
import com.mobei.app.vo.ResultVo;
import com.mobei.common.util.HttpUtils;

/**
 * 轮播图的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 产品列表的控制层定义
     *
     * @param param
     * @return
     */
    @RequestMapping("/list")
    public ResultVo list(ProductParam param) {
        ResultVo result = productService.list(param);
        return result;
    }

    /**
     * 产品详情
     *
     * @param param
     * @return
     */
    @RequestMapping("/detail")
    public ResultVo detail(ProductParam param, HttpServletRequest request) {
        String ipaddr = HttpUtils.getIpAddr(request);
        param.setIpAddr(ipaddr);
        ResultVo result = productService.detail(param);
        return result;
    }

    /** 点击申请 */
    @RequestMapping("/apply")
    public ResultVo apply(HttpServletResponse response, ProductParam param) {

        ResultVo result = productService.apply(param);
        return result;
    }

    /**
     * 提交产品申请
     *
     * @param param
     * @return
     *
     */
    @RequestMapping("/record")
    public ResultVo record(ProductParam param) {
        ResultVo result = productService.record(param);
        return result;
    }

}
