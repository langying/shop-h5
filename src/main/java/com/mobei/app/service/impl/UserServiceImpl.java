package com.mobei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mobei.app.dao.FeedBackMapper;
import com.mobei.app.dao.ProductBrowseMapper;
import com.mobei.app.dao.ProductMapper;
import com.mobei.app.dao.UserMapper;
import com.mobei.app.entity.FeedBackEntity;
import com.mobei.app.entity.ProductBrowseEntity;
import com.mobei.app.entity.ProductEntity;
import com.mobei.app.entity.UserEntity;
import com.mobei.app.param.UserParam;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.PageVo;
import com.mobei.app.vo.ResultVo;
import com.mobei.common.mail.SubMailUtil;
import com.mobei.common.util.DESUtil;
import com.mobei.common.util.MD5Util;
import com.mobei.common.util.NumberUtil;
import com.mobei.common.util.RedisUtils;

/**
 * 用户相关业务处理类定义
 *
 * @author lhl
 * @date 2018-08-08 下午 17:27
 */

@Service("userService")
public class UserServiceImpl {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private FeedBackMapper feedBackMapper;

    @Resource
    private ProductBrowseMapper productBrowseMapper;

    public ResultVo login(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            if (param.getAccount() == null || "".equals(param.getAccount())) {
                result = new ResultVo(CodeVo.USER_LOGIN_ERROR);
                return result;
            }
            if (param.getPassWord() == null && param.getValidCode() == null) {
                result = new ResultVo(CodeVo.USER_LOGIN_ERROR);
                return result;
            }

            UserEntity user = null;
            // 验证码登录
            if (param.getValidCode() != null && !"".equals(param.getValidCode())) {
                // 验证码登录的处理
                String code = (String) redisUtils.get(param.getAccount());
                if (code == null) {
                    return result = new ResultVo(CodeVo.MSM_EXPIRE_ERROR);
                }
                if (!param.getValidCode().equals(code)) {
                    return result = new ResultVo(CodeVo.USER_LOGIN_SMS_ERROR);
                }
                user = userMapper.findByAccount(param.getAccount());

                if (user != null) {
                    result.setData(user);
                    userMapper.saveLogin(user.getUserId());
                }
                else {
                    // 验证通过则进行注册保存
                    String token = DESUtil.encrypt(param.getAccount());
                    user = new UserEntity();
                    user.setIp(param.getIp());
                    user.setAccount(param.getAccount());
                    if (param.getPassWord() != null) {
                        user.setPassWord(MD5Util.md5With16Bit(param.getPassWord()));
                    }
                    user.setToken(token);
                    user.setNickName("lld" + NumberUtil.getRandom());
                    user.setInviteCode(param.getInviteCode());
                    userMapper.save(user);

                    UserEntity resUser = new UserEntity();
                    resUser.setToken(token);
                    resUser.setAccount(param.getAccount());
                    result.setData(resUser);
                    userMapper.saveLogin(user.getId());
                }
            }
            else {
                // 密码登录
                if (param.getPassWord() != null && !"".equals(param.getPassWord())) {
                    user = new UserEntity();
                    user.setAccount(param.getAccount());
                    user.setPassWord(MD5Util.md5With16Bit(param.getPassWord()));
                    user = userMapper.login(user);
                }
                if (user == null) {
                    result = new ResultVo(CodeVo.USER_LOGIN_ERROR);
                    return result;
                }
                userMapper.saveLogin(user.getUserId());
                result.setData(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    public ResultVo register(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            if (param.getAccount() == null || "".equals(param.getAccount())) {
                return result = new ResultVo(CodeVo.ACCOUNT_ERROR);
            }

            if (param.getValidCode() == null || "".equals(param.getValidCode())) {
                return result = new ResultVo(CodeVo.CODE_ERROR);
            }

            UserEntity user = userMapper.findByAccount(param.getAccount());
            if (user != null) {
                return result = new ResultVo(CodeVo.USER_REGISTER_ERROR);
            }

            // 验证码是否正确
            String code = (String) redisUtils.get(param.getAccount());

            if (code == null) {
                return result = new ResultVo(CodeVo.MSM_EXPIRE_ERROR);
            }

            if (!param.getValidCode().equals(code)) {
                return result = new ResultVo(CodeVo.USER_LOGIN_SMS_ERROR);
            }
            // 验证通过则进行注册保存
            String token = DESUtil.encrypt(param.getAccount());
            user = new UserEntity();
            user.setIp(param.getIp());
            user.setAccount(param.getAccount());
            if (param.getPassWord() != null) {
                user.setPassWord(MD5Util.md5With16Bit(param.getPassWord()));
            }
            user.setToken(token);
            user.setNickName("lld" + NumberUtil.getRandom());
            user.setInviteCode(param.getInviteCode());
            userMapper.save(user);

            UserEntity resUser = new UserEntity();
            resUser.setToken(token);
            resUser.setAccount(param.getAccount());
            result.setData(resUser);

        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }

        return result;
    }

    public ResultVo editPwd(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            if (param.getAccount() == null || "".equals(param.getAccount())) {
                return result = new ResultVo(CodeVo.ACCOUNT_ERROR);

            }
            if (param.getPassWord() == null || "".equals(param.getPassWord())) {
                return result = new ResultVo(CodeVo.PWD_ERROR);
            }

            if (param.getValidCode() == null || "".equals(param.getValidCode())) {
                return result = new ResultVo(CodeVo.CODE_ERROR);
            }

            // 验证手机号码是否注册
            UserEntity user = userMapper.findByAccount(param.getAccount());
            if (user == null) {
                return result = new ResultVo(CodeVo.SMS_ERROR);
            }

            // 验证码是否正确
            String code = redisUtils.get(param.getAccount()).toString();
            if (!param.getValidCode().equals(code)) {
                return result = new ResultVo(CodeVo.USER_LOGIN_SMS_ERROR);
            }
            // 验证通过则进行修改保存
            user = new UserEntity();
            user.setAccount(param.getAccount());
            user.setPassWord(MD5Util.md5With16Bit(param.getPassWord()));
            userMapper.update(user);
        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    public ResultVo getCode(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);

        try {
            if (param.getAccount() == null || "".equals(param.getAccount())) {
                return result = new ResultVo(CodeVo.ACCOUNT_ERROR);
            }
            UserEntity user = userMapper.findByAccount(param.getAccount());
            if (param.getType() == 3) { // 登陆页面
                if (user == null) {
                    return result = new ResultVo(CodeVo.SMS_ERROR);
                }
            }
            else if (param.getType() == 2) { // 注册页面
                if (user != null) {
                    return result = new ResultVo(CodeVo.USER_REGISTER_ERROR);
                }
            }
            // 验证码
            String code = NumberUtil.getRandom();
            // 发送验证码
            SubMailUtil.sendSMS(code, param.getType(), param.getAccount());
            // 缓存验证码
            redisUtils.set(param.getAccount(), code);
            redisUtils.expire(param.getAccount(), 1800);
        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }

        return result;
    }

    public ResultVo applyList(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            if (param.getToken() == null) {
                return result = new ResultVo(CodeVo.TOKEN_TEST_ERROR);
            }
            UserEntity user = userMapper.findByToken(param.getToken());
            if (user == null) {
                return result = new ResultVo(CodeVo.TOKEN_FLAG_ERROR);
            }
            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<ProductEntity> list = productMapper.findByUserId(user.getUserId());
            PageVo<ProductEntity> pageInfo = new PageVo<>(list);
            result.setData(pageInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    public ResultVo feedback(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            FeedBackEntity entity = new FeedBackEntity();
            entity.setContent(param.getCotnent());
            entity.setTags(param.getTags());
            UserEntity user = userMapper.findByToken(param.getToken());
            if (user == null) {
                return result = new ResultVo(CodeVo.TOKEN_FLAG_ERROR);
            }
            entity.setUserId(user.getUserId());
            feedBackMapper.save(entity);
        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    public ResultVo browseList(UserParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            if (param.getToken() == null) {
                return result = new ResultVo(CodeVo.TOKEN_TEST_ERROR);
            }
            UserEntity user = userMapper.findByToken(param.getToken());
            if (user == null) {
                return result = new ResultVo(CodeVo.TOKEN_FLAG_ERROR);
            }
            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<ProductBrowseEntity> list = productBrowseMapper.list(user.getUserId());

            PageVo<ProductBrowseEntity> pageInfo = new PageVo<>(list);
            result.setData(pageInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            return result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }
}
