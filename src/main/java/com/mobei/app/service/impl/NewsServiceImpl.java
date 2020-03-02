package com.mobei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mobei.app.dao.NewsMapper;
import com.mobei.app.entity.NewsEntity;
import com.mobei.app.param.NewsParam;
import com.mobei.app.service.NewsService;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.PageVo;
import com.mobei.app.vo.ResultVo;

/**
 * 推广位的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public ResultVo list(NewsParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<NewsEntity> list = newsMapper.list();
            PageVo<NewsEntity> pageInfo = new PageVo<>(list);
            result.setData(pageInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    @Override
    public ResultVo detail(NewsParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            NewsEntity news = newsMapper.findById(param.getId());
            if (news == null) {
                return result = new ResultVo(CodeVo.PRODUCT_EMPTY_ERROR);
            }
            result.setData(news);
            newsMapper.updateBrowse(param.getId());
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }
}
