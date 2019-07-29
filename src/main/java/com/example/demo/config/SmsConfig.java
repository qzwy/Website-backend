package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class SmsConfig {

    //阿里云短信参数
    private String regionId;

    private String accessKeyId;

    private String secret;

    private String templateCode;

    private String signName;

    //腾讯云短信参数
    private String appId;

    private String appKey;

    private String smsSign;

    private String templateId;


    public String getRegionId() {
        return regionId;
    }

    @Value("${aliyun.message.region_id}")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
    @Value("${aliyun.message.access_key_id}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecret() {
        return secret;
    }

    @Value("${aliyun.message.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    @Value("${aliyun.message.template_code}")
    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getSignName() {
        return signName;
    }
    @Value("${aliyun.message.sign_name}")
    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getAppId() {
        return appId;
    }

    @Value("${tencent.app_id}")
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    @Value("${tencent.app_key}")
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSmsSign() {
        return smsSign;
    }

    @Value("${tencent.sms_sign}")
    public void setSmsSign(String smsSign) {
        this.smsSign = smsSign;
    }

    public String getTemplateId() {
        return templateId;
    }

    @Value("${tencent.template_id}")
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
}
