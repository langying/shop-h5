package com.mobei.app.dao;

import com.mobei.app.entity.UserEntity;

/**
 * (描述用途)
 *
 * @author lhl
 * @date 2018-08-08 下午 17:29
 */
public interface UserMapper{


     /**验证用户是否存在*/
     UserEntity findByAccount(String account);

     /**根据token查找用户是否存在*/
     UserEntity findByToken(String token);


     /**登录验证用户名和密码是否正确*/
     UserEntity login(UserEntity entity);

     /**注册保存用户信息*/
     int save(UserEntity entity);

     /**修改用户密码*/
     int update(UserEntity entity);

     /**用户登录记录*/
     int saveLogin(int userId);

}
