package com.sj.pmallfront.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sj.pmallfront.response.BaseResponse;
import com.sj.pmallfront.response.StatusCode;
import com.sj.pmallfront.service.InitService;
import com.sj.pmallgoods.api.entity.MallGoods;
import com.sj.pmallgoods.api.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcurrencyController {

    private static final Logger log= LoggerFactory.getLogger(ConcurrencyController.class);

    private static final String Prefix="concurrency";

    @Autowired
    private InitService initService;

    @Reference
    private GoodsService goodsService;

    @RequestMapping(value = Prefix+"/robbing/thread",method = RequestMethod.GET)
    public BaseResponse robbingThread(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        //是否先判断库存是否为0，为0直接返回
        MallGoods item=goodsService.getGoodsById(1);
        if(item!=null&&item.getStockNum()==0)
        {
            log.info("商品已售完");
            response.setMsg("商品已售完");
            return response;
        }
        initService.generateMultiThread();
        return response;
    }
}







































