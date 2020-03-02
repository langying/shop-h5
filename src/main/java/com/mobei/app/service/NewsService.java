package com.mobei.app.service;

import com.mobei.app.param.NewsParam;
import com.mobei.app.vo.ResultVo;

/**
 * 推广位的业务层定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:01
 */
public interface NewsService {

    /**列表接口*/
    public ResultVo list(NewsParam param);

    /**详情接口*/
    public ResultVo detail(NewsParam param);


}
