package com.sj.pmallfront.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.sj.pmallgoods.api.service.GoodsService;
import com.sj.pmallorder.api.entity.TbOrderRobbingRecord;
import com.sj.pmallorder.api.service.OrderRobbingService;
import org.springframework.stereotype.Service;

@Service
public class TransService {

    @Reference
    private GoodsService itemService;

    @Reference
    private OrderRobbingService orderRobbingService;

    //@Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(timeoutMills = 300000, name = "pmall-front")
    public void transTest()
    {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        itemService.updateStock(562379L);
        TbOrderRobbingRecord entity=new TbOrderRobbingRecord();
        entity.setMobile("666");
        entity.setItemID(562379L);
        orderRobbingService.insertSelective(entity);
        throw new RuntimeException("异常了");
    }
}
