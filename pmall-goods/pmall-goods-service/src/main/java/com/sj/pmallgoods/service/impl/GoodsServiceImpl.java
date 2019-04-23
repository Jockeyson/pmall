package com.sj.pmallgoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fescar.core.context.RootContext;
import com.sj.pmallgoods.api.service.GoodsService;
import com.sj.pmallgoods.api.entity.MallGoods;
import com.sj.pmallgoods.service.mapper.MallGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service(interfaceClass = GoodsService.class) //dubbo的service，注入接口
@Component //spring注解，扫描包
//@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Override
    public MallGoods getGoodsById(Integer id) {

        return mallGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStock(Integer id) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return mallGoodsMapper.updateStock(id);
         //throw new RuntimeException("异常了");
    }
}
