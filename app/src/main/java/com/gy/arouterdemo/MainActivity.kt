package com.gy.arouterdemo

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gy.arouterdemo.Service.CustomServiceImplA
import com.gy.arouterdemo.Service.CustomServiceImplB
import com.gy.basemodel.Person
import com.gy.basemodel.Student
import kotlinx.android.synthetic.main.activity_main.*

@Route( path = "/app/MainActivity")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ARouter.getInstance().inject(this);
        btn_go_first.setOnClickListener {
            ARouter.getInstance().build("/First/FirstMainActivity").navigation();
        }

        var person = Person();
        person.name = "name";
        person.pass = "pass";
        btn_go_second.setOnClickListener {
            /*跳转携带参数*/
            ARouter.getInstance().build("/second/SecondMainActivity")
                    .withLong("key1",1000)
                    .withString("key2","key2")
                    .withObject("student",Student("gy","123456"))
                    .navigation();
        }

        btn_test_service.setOnClickListener {
            var customA = ARouter.getInstance().build("/service/CustomServiceImplA")
                    .navigation() as CustomServiceImplA
            var customB = ARouter.getInstance().build("/service/CustomServiceImplB")
                    .navigation() as CustomServiceImplB

            customA.getUserName()
            customB.getUserName()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ccccccccccc","destroy");
    }
}
