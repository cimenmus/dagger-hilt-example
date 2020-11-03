package com.fireflyon.hiltexample.di.module

import com.fireflyon.hiltexample.BuildConfig
import com.icmen.TabletDeviceFacadeImpl
import com.icmen.common.common.DeviceFacade
import com.icmen.display.DisplayDeviceFacadeImpl
import com.icmen.strong.StrongDeviceFacadeImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DeviceModule {

    @Provides
    fun provideDeviceFacade(): DeviceFacade {
        return when(BuildConfig.DEVICE_TYPE){
            "XIXUN" -> DisplayDeviceFacadeImpl()
            "STRONG" -> StrongDeviceFacadeImpl()
            else -> TabletDeviceFacadeImpl()
        }
    }
}