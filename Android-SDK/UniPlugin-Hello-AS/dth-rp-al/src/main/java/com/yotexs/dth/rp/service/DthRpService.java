package com.yotexs.dth.rp.service;


import android.widget.Toast;

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
        RPSDK.initialize(mWXSDKInstance.getContext());

        String verifyToken = options.getString(VERIFYTOKEN);
        Toast.makeText(mWXSDKInstance.getContext(), "println输入日志信息------" + verifyToken, Toast.LENGTH_SHORT).show();
        RPSDK.start(verifyToken, mWXSDKInstance.getContext(), new RPSDK.RPCompletedListener(){
            @Override
            public void onAuditResult(RPSDK.AUDIT audit, String s) {
                Toast.makeText(mWXSDKInstance.getContext(), audit + "", Toast.LENGTH_SHORT).show();
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
