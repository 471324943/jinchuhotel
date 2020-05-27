package com.hotel.service;

import com.hotel.domain.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hotel.mapper.GoodsMapper;

import java.util.List;

@Service
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    public List<Goods> findAll() {
        return goodsMapper.selectAll();
    }

    public void deleted(String id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    public void updata(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

}
