package com.mobei.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobei.app.param.UserParam;
import com.mobei.app.service.impl.UserServiceImpl;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.ResultVo;
import com.mobei.common.util.Http;

/**
 * 用户相关的控制层定义
 *
 * @author lhl
 * @date 2018-08-08 下午 15:34
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户登录
     *
     * @param param
     * @return
     */
    @RequestMapping("/login")
    public ResultVo login(UserParam param) {
        param.setIp(Http.getDevInfo());
        ResultVo result = userService.login(param);
        return result;
    }

    /**
     * 获取验证码
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/getCode", method = RequestMethod.POST)
    public ResultVo getCode(UserParam param) {
        if (param.isBad(Http.getUserAgent())) {
            // 如果请求是非法的，直接返回成功好了
            return new ResultVo(CodeVo.SUCCESS);
        }
        ResultVo result = userService.getCode(param);
        return result;
    }

    /**
     * 用户注册
     *
     * @param param
     * @return
     */
    @RequestMapping("/register")
    public ResultVo register(UserParam param) {
        param.setIp(Http.getDevInfo());
        ResultVo result = userService.register(param);
        return result;
    }

    /**
     * 用户修改密码
     *
     * @param param
     * @return
     */
    @RequestMapping("/editPwd")
    public ResultVo editPwd(UserParam param) {
        ResultVo result = userService.editPwd(param);
        return result;
    }

    @RequestMapping("/applyList")
    public ResultVo applyList(UserParam param) {
        ResultVo result = userService.applyList(param);
        return result;
    }

    @RequestMapping("/browseList")
    public ResultVo browseList(UserParam param) {
        ResultVo result = userService.browseList(param);
        return result;
    }

    /**
     * 意见反馈
     *
     * @param param
     * @return
     */
    @RequestMapping("/feedback")
    public ResultVo feedback(UserParam param) {
        ResultVo result = userService.feedback(param);
        return result;
    }

}
