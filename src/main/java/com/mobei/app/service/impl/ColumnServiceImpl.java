package com.mobei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobei.app.dao.ColumnMapper;
import com.mobei.app.entity.ColumnEntity;
import com.mobei.app.param.ColumnParam;
import com.mobei.app.service.ColumnService;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.ResultVo;

/**
 * 推广位的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("columnService")
public class ColumnServiceImpl implements ColumnService {

    @Resource
    private ColumnMapper columnMapper;

    @Override
    public ResultVo list(ColumnParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            List<ColumnEntity> list = columnMapper.list(param.getType());
            result.setData(list);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }
}
