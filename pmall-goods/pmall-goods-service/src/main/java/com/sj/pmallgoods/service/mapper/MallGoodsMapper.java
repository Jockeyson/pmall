package com.sj.pmallgoods.service.mapper;


import com.sj.pmallgoods.api.entity.MallGoods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MallGoodsMapper {
    MallGoods selectByPrimaryKey(Integer id);

    int updateStock(Integer id);
}
