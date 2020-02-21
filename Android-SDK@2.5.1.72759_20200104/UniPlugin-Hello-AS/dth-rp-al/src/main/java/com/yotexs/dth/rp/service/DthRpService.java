package com.yotexs.dth.rp.service;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.rp.RPSDK;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;

/**
 * 人脸服务
 */
public class DthRpService extends WXSDKEngine.DestroyableModule {


    public String VERIFYTOKEN = "verifyToken";

    @JSMethod(uiThread = true)
    public  void show(JSONObject options, final JSCallback jsCallback){
        String verifyToken = options.getString(VERIFYTOKEN);
        RPSDK.start(verifyToken, mWXSDKInstance.getContext(), new RPSDK.RPCompletedListener(){
            @Override
            public void onAuditResult(RPSDK.AUDIT audit, String s) {

                JSONObject result = new JSONObject();
                result.put("audit", audit);
                result.put("s", s);
                jsCallback.invoke(result);
            }
        });
    }

    @Override
    public void destroy() {

    }
}
