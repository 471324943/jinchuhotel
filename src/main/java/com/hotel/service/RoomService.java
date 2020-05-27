package com.hotel.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hotel.mapper.RoomMapper;

@Service
public class RoomService {

    @Resource
    private RoomMapper roomMapper;

}

