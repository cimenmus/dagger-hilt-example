package com.fireflyon.hiltexample.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.icmen.common.utils.SampleUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val savedStateHandle: SavedStateHandle,
    private val sampleUtils: SampleUtils,
): ViewModel() {

    fun printInfo() = sampleUtils.printInfo("ViewModel")
}