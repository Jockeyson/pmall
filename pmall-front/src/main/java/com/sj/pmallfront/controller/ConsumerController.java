package com.sj.pmallfront.controller;


import com.alibaba.dubbo.config.annotation.Reference;


import com.sj.pmallcommon.redis.jedis.RedisUtil2;
import com.sj.pmallfront.service.TransService;
import com.sj.pmallgoods.api.service.GoodsService;
import com.sj.pmallgoods.api.entity.MallGoods;
import com.sj.pmallmember.api.entity.MallMember;
import com.sj.pmallmember.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RedisUtil2 redisUtil2;

    @GetMapping("test")
    public String test()
    {
        return "test";
    }

    @GetMapping("redis")
    public String redisTest()
    {
        redisUtil2.put("redistest","redistest11112222");
        String val=redisUtil2.get("redistest");
        System.out.print(val);
        return "redis";
    }

    @GetMapping("trans")
    public String transTest()
    {
       transService.transTest();
       return "transTest";
    }

    @Reference
    private GoodsService goodsService;

    @Autowired
    private TransService transService;

    @Reference
    private MemberService memberService;

    @RequestMapping("item")
    public MallGoods getGoods(@RequestParam(value="id",defaultValue = "1") Integer id)
    {
        return goodsService.getGoodsById(id);
    }

    @RequestMapping("member")
    public MallMember getMember(@RequestParam(value = "id",defaultValue="1") Integer id,
                                HttpServletRequest request)
    {
        MallMember member= memberService.getMemberById(id);
        request.getSession().setAttribute("member_"+id,member);

        return member;
    }
}
