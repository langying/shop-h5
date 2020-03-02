package com.mobei.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.AgentParam;
import com.mobei.app.service.AgentService;
import com.mobei.common.util.HttpUtils;

/**
 * 第三方链接的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    /**
     * 第三方的控制层定义
     *
     * @param param
     * @return
     */
    @RequestMapping("/link")
    public void link(HttpServletResponse response, AgentParam param, HttpServletRequest request) {
        String ipaddr = HttpUtils.getIpAddr(request);
        param.setIpAddr(ipaddr);
        String result = agentService.link(param);
        try {
            response.sendRedirect(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
