package com.gy.secondmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.gy.basemodel.Person
import com.gy.basemodel.Student
import kotlinx.android.synthetic.main.activity_second_main.*

@Route(path = "/second/SecondMainActivity",extras = 1)
class SecondMainActivity : AppCompatActivity(){

    @Autowired(name = "key1")
    @JvmField
    var key1:Long = 0;
    @Autowired(name = "key2")
    @JvmField
    var key2 : String = ""

    @Autowired(name = "student")
    @JvmField
    var student : Student? = null

    @Autowired(name = "person")
    @JvmField
    var person : Person? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main)
        ARouter.getInstance().inject(this);

        btn_go_app.setOnClickListener {
            ARouter.getInstance().build("/app/MainActivity").navigation()
        }

        btn_go_first.setOnClickListener {
            ARouter.getInstance().build("/First/FirstMainActivity").navigation()
        }
        Log.i("cccccccccccccc","key1==="+key1)
        Log.i("cccccccccccccc","key2==="+key2)
        Log.i("cccccccccccccc","student=="+student?.name+"==="+student?.passWord)
        Log.i("cccccccccccc","person=="+person?.name+"==="+person?.pass)
    }

}