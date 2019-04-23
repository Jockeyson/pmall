package com.sj.pmallmember.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sj.pmallmember.api.service.MemberService;
import com.sj.pmallmember.api.entity.MallMember;
import com.sj.pmallmember.service.mapper.MallMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service(interfaceClass = MemberService.class) //dubbo的service，注入接口
@Component //spring注解，扫描包
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MallMemberMapper mallMemberMapper;

    @Override
    public MallMember getMemberById(int memberId) {

        MallMember mallMember;
        try {
            mallMember=mallMemberMapper.selectByPrimaryKey(memberId);
        }catch (Exception e){
            throw e;
        }
        mallMember.setPassword("");
        return mallMember;
    }
}
