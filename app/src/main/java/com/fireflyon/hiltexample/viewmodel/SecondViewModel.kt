package com.fireflyon.hiltexample.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.icmen.common.repository.SampleRepository
import com.icmen.common.utils.SampleUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    //private val savedStateHandle: SavedStateHandle,
    private val sampleUtils: SampleUtils,
    private val sampleRepository: SampleRepository
): ViewModel() {

    fun printInfo() = sampleUtils.printInfo("ViewModel")

    suspend fun getSampleData() = sampleRepository.getSampleData()

}