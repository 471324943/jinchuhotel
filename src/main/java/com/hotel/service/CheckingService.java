package com.hotel.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hotel.mapper.CheckingMapper;
@Service
public class CheckingService{

    @Resource
    private CheckingMapper checkingMapper;

}
