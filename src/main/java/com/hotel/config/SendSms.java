package com.hotel.config;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSms {

    private static String ACCESS_KEY_ID = "";
    private static String ACCESS_SECRET = "";

    public  static String ERROR_SEND_CODE = "0";

    public static String sendSms(String phone) {
        return (int)((Math.random()*9+1)*100000)+"";/*
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
//      签名
        request.putQueryParameter("SignName", "花开自来");
//      模板
        request.putQueryParameter("TemplateCode", "SMS_171856408");
//        获得验证码
        String verificationCode = (int)((Math.random()*9+1)*100000)+"";
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + verificationCode + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return verificationCode;
        } catch (ServerException e) {
            e.printStackTrace();
            return ERROR_SEND_CODE;
        } catch (ClientException e) {
            e.printStackTrace();
            return ERROR_SEND_CODE;
        }*/
    }


}

