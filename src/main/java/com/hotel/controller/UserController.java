package com.hotel.controller;

import com.hotel.config.SendSms;
import com.hotel.domain.Passenger;
import com.hotel.povo.BaseResult;
import com.hotel.service.UserService;
import com.hotel.utils.CodeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService service;

    private HashMap<String, String> codeMap = new HashMap<>();


    @PostMapping("login")
    public ResponseEntity<BaseResult> login(Passenger user) {
        //接受返回信息
        BaseResult br = null;
        System.out.println(user);

        //查询用户名
        Passenger login = service.login(user.getPhone());

        //判断用户名是否存在
        if (login != null) {
            //用户名存在判断密码
            if (login.getPassword().equals(user.getPassword())) {
                //密码匹配返回登录成功信息
                br = new BaseResult(CodeUtils.OK, "登录成功", login);
            } else {
                //密码错误返回错误信息
                br = new BaseResult(CodeUtils.FALL, "密码错误", null);
            }
        } else {
            //用户名不匹配返回错误信息
            br = new BaseResult(CodeUtils.FALL, "用户名不正确", null);
        }
        //返回最终结果
        return ResponseEntity.ok(br);
    }

    @PostMapping("register")
    public ResponseEntity<BaseResult> register(Passenger user) {
        String code = codeMap.get(user.getPhone());
        BaseResult br = null;
        if (code.equals(user.getCode())) {
            //成功
            Passenger login = service.login(user.getPhone());
            if (login == null) {
                service.register(user);
                br = new BaseResult(CodeUtils.OK, "注册成功", null);
            } else {
                br = new BaseResult(CodeUtils.FALL, "手机号已经注册", null);
            }
        } else {
            br = new BaseResult(CodeUtils.FALL, "验证码不正确", null);
        }
        return ResponseEntity.ok(br);

    }

    @GetMapping("getCode/{phone}")
    public ResponseEntity<BaseResult> getCode(@PathVariable String phone) {
        String code = SendSms.sendSms(phone);
        System.out.println(code);
        codeMap.put(phone, code);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "获取成功", null));
    }

    @GetMapping("infoList")
    public ResponseEntity<BaseResult> infoList() {
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "获取成功", service.findAll()));
    }

    @PostMapping
    public ResponseEntity<BaseResult> add(@RequestBody Passenger user) {
        service.add(user);
        return ResponseEntity.ok(new BaseResult(CodeUtils.OK, "成功", null));
    }

    @PutMapping
    public ResponseEntity<BaseResult> updated(@RequestBody Passenger user) {
        service.updata(user);
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
