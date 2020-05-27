package com.hotel.controller;

import com.hotel.domain.Goods;
import com.hotel.mapper.GoodsMapper;
import com.hotel.povo.BaseResult;
import com.hotel.service.GoodsService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Resource
    private GoodsService service;

    @GetMapping
    public ResponseEntity<BaseResult> findAll() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", service.findAll()));
    }


    @PostMapping
    public ResponseEntity<BaseResult> add(@RequestBody Goods goods) {
        service.add(goods);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @PutMapping
    public ResponseEntity<BaseResult> updated(@RequestBody Goods goods) {
        service.updata(goods);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @DeleteMapping("/{ids}")
    public ResponseEntity<BaseResult> deleted(@PathVariable String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            service.deleted(s);
        }
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }
}
