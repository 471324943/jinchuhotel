package com.hotel.service;

import com.hotel.domain.Passenger;
import com.hotel.mapper.PassengerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hotel.mapper.UserMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {

    @Resource
    private PassengerMapper passengerMapper;


    public Passenger login(String phone) {
        Example example = new Example(Passenger.class);
        example.createCriteria().andEqualTo("phone", phone);
        List<Passenger> adminList = passengerMapper.selectByExample(example);
        return adminList.size() > 0 ? adminList.get(0) : null;
    }

    public void register(Passenger user) {
        passengerMapper.insert(user);
    }

    public List<Passenger> findAll() {
        return passengerMapper.selectAll();
    }

    public void deleted(String id) {
        passengerMapper.deleteByPrimaryKey(id);
    }

    public void updata(Passenger goods) {
        passengerMapper.updateByPrimaryKeySelective(goods);
    }

    public void add(Passenger goods) {
        passengerMapper.insert(goods);
    }
}
