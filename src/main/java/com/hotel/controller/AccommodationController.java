package com.hotel.controller;

import com.hotel.domain.Accommodation;
import com.hotel.povo.AccommodationRequest;
import com.hotel.povo.BaseResult;
import com.hotel.service.AccommodationService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {

    @Resource
    private AccommodationService service;


    @PostMapping
    public ResponseEntity<BaseResult> add(@RequestBody AccommodationRequest request){

        service.add(request);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"成功"));
    }

    @PostMapping("add")
    public ResponseEntity<BaseResult> addQ( AccommodationRequest request){
        System.out.println(request);
        service.add(request);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"成功"));
    }

    @GetMapping
    public ResponseEntity<BaseResult> findAll(){
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"成功",service.findAll()));
    }

    @PutMapping
    public ResponseEntity<BaseResult> checkRoomId(@RequestBody Accommodation accommodation){
        service.editRoomId(accommodation);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"成功"));
    }

    @PutMapping("/check/{aid}")
    public ResponseEntity<BaseResult> check(@PathVariable Integer aid){
        service.check(aid);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"成功"));
    }

    @DeleteMapping("/{aid}")
    public ResponseEntity<BaseResult> checkOut(@PathVariable Integer aid){
        service.checkOut(aid);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK,"成功"));
    }
}
