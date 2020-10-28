package com.fireflyon.hiltexample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fireflyon.hiltexample.utils.NetworkUtils
import com.fireflyon.hiltexample.common.autoCleared
import javax.inject.Inject

abstract class BaseFragment<VB: ViewDataBinding, VM: ViewModel>: Fragment() {

    // val viewModel: SampleViewModel by viewModels()
    // val viewModel2: VM by viewModels()
    val viewModel: VM by lazy { ViewModelProvider(this).get(getViewModelKey()) }
    var binding: VB by autoCleared()

    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readDataFromArguments()
        initViews()
        initObservers()
        initLogic()
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun getViewModelKey(): Class<VM>

    open fun readDataFromArguments() {}

    open fun initViews() {}

    open fun initObservers() {}

    open fun initLogic() {
        networkUtils.printInfo("BaseFragment")
    }

}