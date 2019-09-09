package com.gy.basemodel

import android.os.Handler
import android.os.Looper

class MainLooper constructor(looper: Looper): Handler(looper){

    companion object{

        val _instance = MainLooper(Looper.getMainLooper());

        fun getInstance() : MainLooper{
            return _instance
        }

        fun runOnUiThread(runnable:Runnable){
          if(Looper.getMainLooper().equals(Looper.myLooper())){
              runnable.run()
          }else{
              _instance.post(runnable)
          }
        }
    }

}