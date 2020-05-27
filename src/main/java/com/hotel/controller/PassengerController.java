package com.hotel.controller;

import com.hotel.domain.Passenger;
import com.hotel.povo.BaseResult;
import com.hotel.service.PassengerService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Resource
    private PassengerService passengerService;

    @GetMapping
    private ResponseEntity<BaseResult> findAll(){
        List<Passenger> all = passengerService.findAll();
        for (Passenger passenger : all) {

            System.out.println(passenger);
        }
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"查询成功",all));
    }
}
