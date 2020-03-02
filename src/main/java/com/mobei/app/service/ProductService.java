package com.mobei.app.service;

import com.mobei.app.param.ProductParam;
import com.mobei.app.vo.ResultVo;

/**
 * 产品的业务层定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:01
 */
public interface ProductService {

    /**列表接口*/
    public ResultVo list(ProductParam param);

    /**详情接口*/
    public ResultVo detail(ProductParam param);

    /**第三方链接*/
    public ResultVo apply(ProductParam param);

    /**提交申请记录*/
    public ResultVo record(ProductParam param);


}
