package com.gy.arouterdemo

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

@Interceptor(priority = 8,name = "测试拦截器")
class CustomInterceptor : IInterceptor{

    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        var extra = postcard.extra ;
        /*要么继续往下执行*/
        callback.onContinue(postcard);  // 处理完成，交还控制权
        /*要么抛异常*/
        // callback.onInterrupt(new RuntimeException("我觉得有点异常"));
    }

    override fun init(context: Context?) {

    }

}