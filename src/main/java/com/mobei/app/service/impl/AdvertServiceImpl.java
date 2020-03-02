package com.mobei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mobei.app.dao.AdvertMapper;
import com.mobei.app.entity.MessageEntity;
import com.mobei.app.param.BaseParam;
import com.mobei.app.service.AdvertService;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.PageVo;
import com.mobei.app.vo.ResultVo;

/**
 * 轮播图的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("advertService")
public class AdvertServiceImpl implements AdvertService {

    @Resource
    private AdvertMapper advertMapper;

    @Override
    public ResultVo list(BaseParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            param.setPageSize(5);
            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<MessageEntity> list = advertMapper.list();
            PageVo<MessageEntity> pageInfo = new PageVo<>(list);
            result.setData(pageInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;

    }
}
