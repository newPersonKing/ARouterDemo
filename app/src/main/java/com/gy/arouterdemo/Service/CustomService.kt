package com.gy.arouterdemo.Service

import com.alibaba.android.arouter.facade.template.IProvider

abstract class  CustomService : IProvider{

    abstract fun getUserName();
}