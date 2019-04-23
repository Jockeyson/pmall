package com.sj.pmallmember.api.service;

import com.sj.pmallmember.api.entity.MallMember;

public interface MemberService {
    /**
     * 根据ID获取会员信息
     * @param memberId
     * @return
     */
    MallMember getMemberById(int memberId);
}
