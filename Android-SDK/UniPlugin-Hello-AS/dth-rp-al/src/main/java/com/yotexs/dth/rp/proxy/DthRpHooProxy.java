package com.yotexs.dth.rp.proxy;

import android.app.Application;

import com.alibaba.security.rp.RPSDK;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.yotexs.dth.rp.service.DthRpService;

import io.dcloud.weex.AppHookProxy;

/**
 * 初始化人脸插件
 */
public class DthRpHooProxy extends WXSDKEngine.DestroyableModule implements AppHookProxy  {

    @Override
    public void onCreate(Application application) {
        System.out.println("println输入日志信息");
        try{
            WXSDKEngine.registerModule("DTH-RP-ALY", DthRpService.class);

        }catch (WXException e){
            e.printStackTrace();
        }

//        RPSDK.initialize(mWXSDKInstance.getContext());
    }

    @Override
    public void destroy() {

    }
}
