package com.yotexs.dth.rp.proxy;

import android.app.Application;

import com.alibaba.security.rp.RPSDK;
import com.taobao.weex.WXSDKEngine;

import io.dcloud.weex.AppHookProxy;

/**
 * 初始化人脸插件
 */
public class DthRpHooProxy extends WXSDKEngine.DestroyableModule implements AppHookProxy  {

    @Override
    public void onCreate(Application application) {
        RPSDK.initialize(mWXSDKInstance.getContext());
    }

    @Override
    public void destroy() {

    }
}
