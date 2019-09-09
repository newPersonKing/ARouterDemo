package com.gy.firstmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_first_main.*


@Route(path = "/First/FirstMainActivity")
class FirstMainActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this);
        setContentView(R.layout.activity_first_main)

        btn_go_app.setOnClickListener {
            ARouter.getInstance().build("/app/MainActivity").navigation();
        }

        btn_go_second.setOnClickListener {
            ARouter.getInstance().build("/second/SecondMainActivity").navigation();
        }
    }

}