package com.gy.arouterdemo.Service

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = "/service/CustomServiceImplB")
class CustomServiceImplB :CustomService(){
    override fun init(context: Context?) {
    }

    override fun getUserName() {
        Log.i("ccccccccccc","CustomServiceImplB");
    }

}