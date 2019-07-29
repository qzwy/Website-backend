package com.example.demo.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.demo.config.SmsConfig;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * 阿里云和腾讯云短信服务
 * @Date 2019/04/04
 */
@RestController
@RequestMapping("/message")
public class SmsController {

    @Autowired
    private SmsConfig smsConfig;

    /**
     * 阿里云短信发送
     * @param phoneNumber
     */
    @GetMapping("/sendMsg/{phoneNumber}")
    public void useAliSend(@PathVariable String phoneNumber){
        DefaultProfile profile = DefaultProfile.getProfile("default", smsConfig.getAccessKeyId(), smsConfig.getSecret());
        IAcsClient client = new DefaultAcsClient(profile) ;

        //生成验证码
        String randomNumber = productRandomNumber(6);
        String jsonContent = "{\"code\": \"" + randomNumber + "\"}";

        CommonRequest request = new CommonRequest();
        request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyun.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", smsConfig.getSignName());
        request.putQueryParameter("TemplateCode", smsConfig.getTemplateCode());
        request.putQueryParameter("TemplateParam", jsonContent);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("response = " + response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }


    /**
     * 腾讯云短信发送
     */
    @GetMapping("/sendMsg2/{phoneNumber}")
    public ResponseEntity<?> smsFromTC(@PathVariable String phoneNumber) {
        int appid = Integer.valueOf(smsConfig.getAppId());
        String appkey = smsConfig.getAppKey();
        int templateId = Integer.valueOf(smsConfig.getTemplateId());
        String smsSign = smsConfig.getSmsSign();
        String code = productRandomNumber(6);
        ArrayList<String> params = new ArrayList<>();
        params.add(code);
        params.add("5");
        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,
                    templateId, params, smsSign, "", "");
        } catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return ResponseEntity.ok("successfully");
    }


    /**
     * 验证码生成
     * @param n
     * @return
     */
    public String productRandomNumber(int n){
        String randomNum = "";
        Random random = new Random();
        for(int i = 0; i < n; i++){
            randomNum = randomNum + random.nextInt(10);
        }
        return randomNum;
    }
}
