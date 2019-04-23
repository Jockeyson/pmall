package com.sj.pmallorder.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sj.pmallorder.api.entity.MallOrder;
import com.sj.pmallorder.api.service.OrderService;
import com.sj.pmallorder.service.mapper.MallOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service(interfaceClass = OrderService.class) //dubbo的service，注入接口
@Component //spring注解，扫描包
//@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MallOrderMapper mallOrderMapper;

    @Override
    public int insert(MallOrder order) {
        return mallOrderMapper.insert(order);
    }
}
