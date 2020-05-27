package com.hotel.controller;

import com.github.pagehelper.page.PageParams;
import com.hotel.domain.Room;
import com.hotel.domain.RoomType;
import com.hotel.povo.BaseResult;
import com.hotel.povo.PagePramas;
import com.hotel.povo.PageResult;
import com.hotel.service.RoomTypeService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("room")
@RestController
public class RoomController {
    @Resource
    private RoomTypeService service;

    @GetMapping
    public ResponseEntity<BaseResult> findAll() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", service.findAllRoom()));
    }

    @GetMapping("findAll/index")
    public ResponseEntity<BaseResult> findByIndex() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "查询成功", service.findByPage()));
    }

    @GetMapping("findAll/allList")
    public ResponseEntity<BaseResult> findByList1() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", service.findAllRoomType()));
    }

    @GetMapping("findAll/list")
    public ResponseEntity<PageResult> findByList(PagePramas params) {
        return ResponseEntity.ok(service.findAll(params));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResult> findById(@PathVariable String id) {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "查询成功", service.findById(id)));
    }

    @GetMapping("/usableList")
    public ResponseEntity<BaseResult> usableList() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "查询成功", service.usableList()));
    }


    @PostMapping
    public ResponseEntity<BaseResult> add(@RequestBody Room room) {
        service.add(room);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @PutMapping
    public ResponseEntity<BaseResult> updated(@RequestBody Room room) {
        service.updata(room);
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

    @PostMapping("/type")
    public ResponseEntity<BaseResult> typeAdd(@RequestBody RoomType room) {
        System.out.println(room);
        service.typeAdd(room);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @PutMapping("/type")
    public ResponseEntity<BaseResult> typeUpdata(@RequestBody RoomType room) {
        service.typeUpdata(room);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @DeleteMapping("/type/{ids}")
    public ResponseEntity<BaseResult> typeDeleted(@PathVariable String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            service.typeDeleted(s);
        }
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }
}
