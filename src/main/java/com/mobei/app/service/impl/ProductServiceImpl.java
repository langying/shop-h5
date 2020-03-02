package com.mobei.app.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.mobei.app.dao.MessageMapper;
import com.mobei.app.dao.ProductBrowseMapper;
import com.mobei.app.dao.ProductMapper;
import com.mobei.app.dao.UserMapper;
import com.mobei.app.entity.ApplyEntity;
import com.mobei.app.entity.MessageEntity;
import com.mobei.app.entity.ProductEntity;
import com.mobei.app.entity.UserEntity;
import com.mobei.app.param.ProductParam;
import com.mobei.app.service.ProductService;
import com.mobei.app.vo.CodeVo;
import com.mobei.app.vo.PageVo;
import com.mobei.app.vo.ResultVo;
import com.mobei.common.util.DateUtils;

/**
 * 产品的业务层处理业务的实体类定义
 *
 * @author lhl
 * @date 2018-08-10 下午 18:06
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private ProductBrowseMapper productBrowseMapper;

    @Override
    public ResultVo list(ProductParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            PageHelper.startPage(param.getPage(), param.getPageSize());
            List<ProductEntity> list = null;
            if (param.getColumnId() > 0) {// 根据类别查询
                list = productMapper.getColumnList(param);
            }
            else {
                list = productMapper.list(param);
            }
            PageVo<ProductEntity> pageInfo = new PageVo<>(list);
            result.setData(pageInfo);
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    @Override
    public ResultVo detail(ProductParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            ProductEntity product = productMapper.findById(param.getProductId());
            if (product == null) {
                return result = new ResultVo(CodeVo.PRODUCT_EMPTY_ERROR);
            }
            // product.setLinkUrl(InitJiGuangConfig.PRODUCT_APPLY+"?productId="+param.getProductId());
            result.setData(product);

            if (param.getMessageId() > 0) {
                UserEntity user = userMapper.findByToken(param.getToken());// 查询用户信息
                MessageEntity message = messageMapper.isLook(user.getUserId(), param.getMessageId());// 查询是否已经观看
                if (message == null) {
                    messageMapper.saveLook(user.getUserId(), param.getMessageId());// 添加记录
                }
            }
            else {
                try {
                    UserEntity user = userMapper.findByToken(param.getToken());// 查询用户信息
                    String days = DateUtils.format(new Date());

                    if (user != null) {
                        productBrowseMapper.save(user.getUserId(), param.getProductId(), days, param.getUdid(), param.getIpAddr());// 保存浏览记录
                    }
                    else {
                        productBrowseMapper.save(0, param.getProductId(), days, param.getUdid(), param.getIpAddr());// 保存浏览记录
                    }
                }
                catch (Exception e) {
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    @Override
    public ResultVo apply(ProductParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        ProductEntity product = productMapper.findById(param.getProductId());// 查询产品详情
        try {
            UserEntity user = userMapper.findByToken(param.getToken());// 查询用户信息
            if (user != null) {
                productMapper.saveApply(user.getUserId(), param.getProductId());// 保存申请记录
            }
            else {
                productMapper.saveApply(0, param.getProductId());// 保存申请记录
            }
            if (param.getProductId() > 0) {// 申请人数加1
                productMapper.updateTotal(param.getProductId());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }

    @Override
    public ResultVo record(ProductParam param) {
        ResultVo result = new ResultVo(CodeVo.SUCCESS);
        try {
            UserEntity user = userMapper.findByToken(param.getToken());// 查询用户信息
            if (user != null) {
                ApplyEntity apply = new ApplyEntity();
                apply.setUserId(user.getUserId());
                apply.setProductId(param.getProductId());
                apply.setType(param.getType());
                if (apply.getType() == 3) {
                    apply.setContent(param.getContent());
                }
                productMapper.saveRecord(apply);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            result = new ResultVo(CodeVo.ERROR);
        }
        return result;
    }
}
