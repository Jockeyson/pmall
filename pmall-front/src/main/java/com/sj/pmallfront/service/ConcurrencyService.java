package com.sj.pmallfront.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.sj.pmallgoods.api.entity.MallGoods;
import com.sj.pmallgoods.api.service.GoodsService;
import com.sj.pmallorder.api.entity.TbOrderRobbingRecord;
import com.sj.pmallorder.api.service.OrderRobbingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/8/25.
 */
@Service
public class ConcurrencyService {

    private static final Logger log= LoggerFactory.getLogger(ConcurrencyService.class);

    //private static final String ProductNo="product_10010";
    private static final Long ItemID=562379L;

    @Reference
    private GoodsService itemService;

    @Reference
    private OrderRobbingService orderRobbingService;

    /**
     * 处理抢单，线程安全问题？
     * @param mobile
     */
    @GlobalTransactional(timeoutMills = 300000, name = "pmall-front")
    public void manageRobbing(String mobile){
        /*try {
            Product product=productMapper.selectByProductNo(ProductNo);
            if (product!=null && product.getTotal()>0){
                log.info("当前手机号：{} 恭喜您抢到单了!",mobile);
                productMapper.updateTotal(product);
            }else{
                log.error("当前手机号：{} 抢不到单!",mobile);

            }
        }catch (Exception e){
            log.error("处理抢单发生异常：mobile={} ",mobile);
        }*/ //--v1.0


        //+v2.0
        try {
            MallGoods item=itemService.getNormalItemById(ItemID);
            if (item!=null && item.getNum()>0){
                int result=itemService.updateStock(ItemID);
                if (result>0) {
                    TbOrderRobbingRecord entity=new TbOrderRobbingRecord();
                    entity.setMobile(mobile);
                    entity.setItemID(item.getId());
                    orderRobbingService.insertSelective(entity);
                    throw new RuntimeException("异常了");
                    //异步通知用户抢单成功
                    //log.info("当前手机号：{} 抢单成功！",mobile);
                }
            }
            else
            {
                log.info("商品已售完，当前手机号：{} 抢单失败！",mobile);
            }
        }catch (Exception e){
            log.error("处理抢单发生异常：{} ",e.getMessage());
        }
    }
}

















