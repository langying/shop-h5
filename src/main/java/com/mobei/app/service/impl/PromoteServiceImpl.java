package com.mobei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobei.app.dao.PromoteMapper;
import com.mobei.app.entity.PromoteEntity;
import com.mobei.app.param.BaseParam;
import com.mobei.app.service.PromoteService;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.ResultVo;

/**
 * 推广位的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("promoteService")
public class PromoteServiceImpl implements PromoteService {

    @Resource
    private PromoteMapper promoteMapper;

    @Override
    public ResultVo list(BaseParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            List<PromoteEntity> list = promoteMapper.list();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getType() == 3) {
                    list.get(i).setColumnId(list.get(i).getProductId());
                }
            }
            result.setData(list);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }
}
