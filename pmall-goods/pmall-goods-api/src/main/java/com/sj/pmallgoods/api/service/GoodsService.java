package com.sj.pmallgoods.api.service;

import com.sj.pmallgoods.api.entity.MallGoods;

public interface GoodsService {
    /**
     * 通过ID获取不包含详情
     * @param id
     * @return
     */
    MallGoods getGoodsById(Integer id);

    int updateStock(Integer id);
}
