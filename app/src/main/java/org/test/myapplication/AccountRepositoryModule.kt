package org.test.myapplication


import com.healthsignz.doctor.account.model.LoginRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AccountRepositoryModule {
     
    @Singleton
    @Provides
    fun provideRepositoryModule(api : Api,preferences: Preferences) : IAccountRepository{
        return AccountRepositoryImpl(api,preferences)
    }

}