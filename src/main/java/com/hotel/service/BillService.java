package com.hotel.service;

import com.hotel.domain.Bill;
import com.hotel.povo.BaseResult;
import com.hotel.povo.BillVo;
import com.hotel.povo.SexVo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hotel.mapper.BillMapper;

import java.util.List;

@Service
public class BillService {


    @Resource
    private BillMapper billMapper;

    public List<Bill> findAllByDate() {
        return billMapper.findAllByDate();
    }

    public List<Bill> findAllByQuarter() {
        return billMapper.findAllByQuarter();
    }

    public List<Bill> findAllByYear() {
        return billMapper.findAllByYear();
    }

    public List<BillVo> findBySum() {
        return billMapper.findBySum();
    }
    public List<SexVo> findSex(){
        return billMapper.findSex();
    }

}
