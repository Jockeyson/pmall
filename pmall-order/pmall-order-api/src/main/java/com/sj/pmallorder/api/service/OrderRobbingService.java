package com.sj.pmallorder.api.service;

import com.sj.pmallorder.api.entity.MallOrderRobbingRecord;

public interface OrderRobbingService {
    int insertSelective(MallOrderRobbingRecord record);
}
