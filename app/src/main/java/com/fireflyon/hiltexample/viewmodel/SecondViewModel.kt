package com.fireflyon.hiltexample.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.icmen.common.repository.SampleRepository
import com.icmen.common.utils.SampleUtils

class SecondViewModel
@ViewModelInject constructor(
    private val sampleUtils: SampleUtils,
    private val sampleRepository: SampleRepository
    //@Assisted private val savedStateHandle: SavedStateHandle
): ViewModel() {

    fun printInfo() = sampleUtils.printInfo("ViewModel")

    suspend fun getSampleData() = sampleRepository.getSampleData()

}