package com.mobei.app.dao;

import com.mobei.app.entity.ThirdEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 第三方链接的dao层接口定义
 *
 * @author lhl
 * @date 2018-08-10 下午 19:06
 */
public interface ThirdMapper {


    /**
     * 分页查询列表
     *
     * @return
     */
    ThirdEntity findByCode(String code);


    /**添加申请记录*/
    int saveApply(@Param("userId") int userId, @Param("thirdId") int thirdId,@Param("ipAddr") String ipAddr);

    /**添加申请人数*/
    int updateTotal(int thirdId);
}
