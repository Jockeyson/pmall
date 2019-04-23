package com.sj.pmallmember.service.mapper;

import com.sj.pmallmember.api.entity.MallMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MallMemberMapper {
    MallMember selectByPrimaryKey(int id);
}
