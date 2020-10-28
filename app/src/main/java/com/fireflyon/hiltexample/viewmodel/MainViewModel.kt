package com.fireflyon.hiltexample.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.fireflyon.hiltexample.utils.SampleUtils

class MainViewModel
@ViewModelInject constructor(
    private val sampleUtils: SampleUtils,
    //@Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    fun printInfo() = sampleUtils.printInfo("ViewModel")
}