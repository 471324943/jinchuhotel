package com.hotel.service;

import com.hotel.domain.Passenger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hotel.mapper.PassengerMapper;

import java.util.List;

@Service
public class PassengerService{

    @Resource
    private PassengerMapper passengerMapper;

    public void install(Passenger passenger){
        passengerMapper.insert(passenger);
    }

    public List<Passenger> findAll(){
        return passengerMapper.selectAll();
    }

}
