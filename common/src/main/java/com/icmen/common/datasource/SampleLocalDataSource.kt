package com.icmen.common.datasource

import com.icmen.common.database.SampleDao
import com.icmen.common.common.SampleData
import com.icmen.common.utils.SampleUtils
import javax.inject.Inject

class SampleLocalDataSource
@Inject constructor(private val sampleUtils: SampleUtils,
                    private val sampleDao: SampleDao): SampleDataSource {

    override suspend fun getSampleData(): SampleData {
        sampleUtils.printInfo("SampleLocalDataSource")
        val sampleDataList = sampleDao.getAll()
        return if(sampleDataList.isNotEmpty()){
            return sampleDataList.last()
        }
        else {
            SampleData(id = "1234", name = "abcd")
        }
    }

    override suspend fun saveSampleData(data: SampleData) {
        sampleDao.add(data)
    }
}