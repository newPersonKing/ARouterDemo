package com.gy.arouterdemo

import android.app.AlertDialog
import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import android.content.DialogInterface
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.gy.basemodel.MainLooper

/*代表执行的优先机*/
@Interceptor(priority = 1)
class Test1Interceptor : IInterceptor{
    lateinit var mContext : Context;
    override fun init(context: Context) {
        mContext = context;
    }

    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        var path = postcard.path;
        if(path.equals("/First/FirstMainActivity")){
            // 这里的弹窗仅做举例，代码写法不具有可参考价值
            val ab = AlertDialog.Builder(MyApplication.context)
            ab.setCancelable(false)
            ab.setTitle("温馨提醒")
            ab.setMessage("想要跳转到Test4Activity么？(触发了\"/inter/test1\"拦截器，拦截了本次跳转)")
            ab.setNegativeButton("继续", DialogInterface.OnClickListener { dialog, which -> callback.onContinue(postcard) })
            ab.setNeutralButton("算了", DialogInterface.OnClickListener { dialog, which -> callback.onInterrupt(null) })
            ab.setPositiveButton("加点料", DialogInterface.OnClickListener { dialog, which ->
                postcard.withString("extra", "我是在拦截器中附加的参数")
                callback.onContinue(postcard)
            })

            MainLooper.runOnUiThread(object :Runnable{
                override fun run() {
                    ab.create().show();
                }
            })
        }else{
            callback.onContinue(postcard)
        }
    }

}