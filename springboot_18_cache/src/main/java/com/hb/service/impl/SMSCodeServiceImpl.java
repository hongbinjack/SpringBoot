package com.hb.service.impl;

import com.hb.domain.SMSCode;
import com.hb.service.SMSCodeService;
import com.hb.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {


    @Autowired
    private CodeUtils codeUtils;

    @Override
    @CachePut(value = "smsCode",key = "#tele")
    public String sendCodeToSMS(String tele) {
      String code = codeUtils.generator(tele);
      /*
      这里在测试的时候老是返回自己传入的电话号码，是因为code这里写成了tele，也就是返回了
      传入的电话号码参数
       */
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        //去除内存中的验证码与传递过来的验证码比对，如果相同，返回true
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTele());
        return code.equals(cacheCode);
    }

//    @Cacheable(value = "smsCode",key = "#tele")
//    public String get(String tele){
//        return null;
//    }
}
