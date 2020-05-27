package com.hotel.controller;

import com.hotel.domain.Bill;
import com.hotel.povo.BaseResult;
import com.hotel.service.BillService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RequestMapping("bill")
@RestController
public class BillController {

    @Resource
    private BillService billService;

    @GetMapping("/date/{num}")
    public ResponseEntity<BaseResult> findAllByDate(@PathVariable Integer num) {
        List<Bill> data = null;
        switch (num) {
            case 0:
                data = billService.findAllByDate();
                break;
            case 1:
                data = billService.findAllByQuarter();
                break;
            case 2:
                data = billService.findAllByYear();
                break;
        }

        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", data));
    }

    @GetMapping("quarter")
    public ResponseEntity<BaseResult> findAllByQuarter() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", billService.findAllByQuarter()));
    }

    @GetMapping("year")
    public ResponseEntity<BaseResult> findAllByYear() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", billService.findAllByYear()));
    }

    @GetMapping("sum")
    public ResponseEntity<BaseResult> findBySum() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", billService.findBySum()));
    }

    @GetMapping("sex")
    public ResponseEntity<BaseResult> findSex() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", billService.findSex()));
    }



}
