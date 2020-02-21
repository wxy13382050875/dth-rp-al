package com.example.my_test;

import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;

public class TestWxModule extends WXSDKEngine.DestroyableModule {

    @JSMethod(uiThread = true)
    public  void show(JSONObject options, JSCallback jsCallback){
        Toast ts = Toast.makeText(mWXSDKInstance.getContext(),"原生方法Toast提示"+ options.toJSONString(),Toast.LENGTH_LONG);
        ts.show();
    }
    @Override
    public void destroy() {

    }
}
