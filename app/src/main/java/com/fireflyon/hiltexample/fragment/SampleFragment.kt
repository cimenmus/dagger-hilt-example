package com.fireflyon.hiltexample.fragment

import android.content.Intent
import android.util.Log
import com.fireflyon.hiltexample.*
import com.fireflyon.hiltexample.broadcast.SampleBroadcastReceiver
import com.fireflyon.hiltexample.databinding.FragmentSampleBinding
import com.fireflyon.hiltexample.service.SampleService
import com.fireflyon.hiltexample.utils.SampleUtils
import com.fireflyon.hiltexample.viewmodel.SampleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_sample.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SampleFragment: BaseFragment<FragmentSampleBinding, SampleViewModel>() {

    @Inject lateinit var sampleUtils: SampleUtils

    companion object {
        @JvmStatic
        fun newInstance(): SampleFragment = SampleFragment()
    }

    override fun getLayoutRes() = R.layout.fragment_sample

    override fun getViewModelKey() = SampleViewModel::class.java

    override fun initLogic(){
        super.initLogic()
        print(sampleUtils.printInfo("Fragment"))
        startSampleService()
        sendSampleBroadcast()
        startViewModel()
    }

    override fun initViews() {
        super.initViews()
        //binding.sampleTextView.setText("Text is changed via Binding")
        sampleTextView.setText("Text is changed via KotlinX Synthetic")
    }

    private fun startSampleService(){
        val serviceIntent = Intent(context, SampleService::class.java)
        context?.startService(serviceIntent)
    }

    private fun sendSampleBroadcast(){
        Intent(context, SampleBroadcastReceiver::class.java).apply {
            action = "com.fireflyon.fireplay.SAMPLE_BROADCAST"
            context?.sendBroadcast(this)
        }
    }

    private fun startViewModel(){
        viewModel.printInfo()
        GlobalScope.launch {
            val data = viewModel.getSampleData()
            Log.i("mstf", "id: ${data.id} name: ${data.name}")
        }
    }
}