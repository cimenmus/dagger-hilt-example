package com.fireflyon.hiltexample.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fireflyon.hiltexample.utils.NetworkUtils
import javax.inject.Inject

abstract class BaseActivity<VB: ViewDataBinding, VM: ViewModel>: AppCompatActivity(){

    @Inject
    lateinit var networkUtils: NetworkUtils

    val viewModel: VM by lazy { ViewModelProvider(this).get(getViewModelKey()) }
    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        //binding = DataBindingUtil.setContentView(this, getLayoutRes())
        readDataFromIntent()
        initViews()
        initLogic()
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun getViewModelKey(): Class<VM>

    open fun initViews() {}

    open fun readDataFromIntent() {}

    open fun initLogic() {
        networkUtils.printInfo("BaseActivity")
    }
}