package com.fireflyon.hiltexample.activity

import android.util.Log
import com.fireflyon.hiltexample.viewmodel.MainViewModel
import com.fireflyon.hiltexample.R
import com.fireflyon.hiltexample.fragment.SampleFragment
import com.icmen.common.utils.SampleUtils
import com.fireflyon.hiltexample.databinding.ActivityMainBinding
import com.fireflyon.hiltexample.fragment.SecondFragment
import com.icmen.common.common.DeviceFacade
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject
import  kotlin.concurrent.schedule

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var sampleUtils: SampleUtils

    @Inject
    lateinit var deviceFacade: DeviceFacade

    private var timer = Timer("sampleTimer", false)

    override fun getLayoutRes() = R.layout.activity_main

    override fun getViewModelKey() = MainViewModel::class.java

    override fun initViews() {
        super.initViews()
        showFragment()
    }

    override fun initLogic() {
        super.initLogic()
        print(sampleUtils.printInfo("Activity"))
        viewModel.printInfo()
        Log.i("mstf", deviceFacade.getDeviceType())
    }

    private fun showFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, SampleFragment.newInstance())
            .commit()

        timer.schedule(10 * 1000) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, SecondFragment.newInstance())
                .commit()
        }
    }

}