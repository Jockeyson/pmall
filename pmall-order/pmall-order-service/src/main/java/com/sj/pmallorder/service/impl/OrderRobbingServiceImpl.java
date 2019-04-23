package com.sj.pmallorder.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fescar.core.context.RootContext;
import com.sj.pmallorder.api.entity.MallOrderRobbingRecord;
import com.sj.pmallorder.api.service.OrderRobbingService;
import com.sj.pmallorder.service.mapper.MallOrderRobbingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service(interfaceClass = OrderRobbingService.class) //dubbo的service，注入接口
@Component //spring注解，扫描包
//@Transactional(rollbackFor = Exception.class)
public class OrderRobbingServiceImpl implements OrderRobbingService {

    @Autowired
   private MallOrderRobbingMapper mallOrderRobbingMapper;

   @Override
    public int insertSelective(MallOrderRobbingRecord record) {
       System.out.println("全局事务id ：" + RootContext.getXID());
        return mallOrderRobbingMapper.insertSelective(record);
    }
}
