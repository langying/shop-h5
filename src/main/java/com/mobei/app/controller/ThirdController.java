package com.mobei.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.ThirdParam;
import com.mobei.app.service.ThirdService;
import com.mobei.common.util.HttpUtils;

/**
 * 第三方链接的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/third")
public class ThirdController {

    @Autowired
    private ThirdService thirdService;

    /**
     * 第三方的控制层定义
     *
     * @param param
     * @return
     */
    @RequestMapping("/link")
    public void link(HttpServletResponse response, ThirdParam param, HttpServletRequest request) {
        String ipaddr = HttpUtils.getIpAddr(request);
        param.setIpAddr(ipaddr);
        String result = thirdService.link(param);
        try {
            response.sendRedirect(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
