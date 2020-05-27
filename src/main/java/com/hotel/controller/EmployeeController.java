package com.hotel.controller;

import com.hotel.domain.Employee;
import com.hotel.povo.BaseResult;
import com.hotel.service.EmployeeService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private EmployeeService service;

    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody Employee employee) {
        BaseResult br = null;
        System.out.println(employee);

        Employee login = service.login(employee.getJobNumber());

        if (login != null) {
            if (login.getPassword().equals(employee.getPassword())) {
                br = new BaseResult(CodeUtils.OK, "登录成功", login);
            } else {
                br = new BaseResult(CodeUtils.FALL, "登录失败");
            }
        } else {
            br = new BaseResult(CodeUtils.FALL, "登录失败");
        }
        return ResponseEntity.ok(br);
    }

    @GetMapping
    public ResponseEntity<BaseResult> findAll() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", service.findAll()));
    }


    @PostMapping
    public ResponseEntity<BaseResult> add(@RequestBody Employee employee) {
        service.add(employee);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @PutMapping
    public ResponseEntity<BaseResult> updated(@RequestBody Employee employee) {
        service.updata(employee);
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
