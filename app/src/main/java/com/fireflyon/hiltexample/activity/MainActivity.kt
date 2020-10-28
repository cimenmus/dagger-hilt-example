package com.fireflyon.hiltexample.activity

import com.fireflyon.hiltexample.viewmodel.MainViewModel
import com.fireflyon.hiltexample.R
import com.fireflyon.hiltexample.fragment.SampleFragment
import com.fireflyon.hiltexample.utils.SampleUtils
import com.fireflyon.hiltexample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var sampleUtils: SampleUtils

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
    }

    private fun showFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, SampleFragment.newInstance())
            .commit()
    }

}