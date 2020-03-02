package com.mobei.app.service;

import com.mobei.app.param.BaseParam;
import com.mobei.app.vo.ResultVo;

/**
 * 推广位的业务层定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:01
 */
public interface PromoteService {

    /**列表接口*/
    public ResultVo list(BaseParam param);


}
