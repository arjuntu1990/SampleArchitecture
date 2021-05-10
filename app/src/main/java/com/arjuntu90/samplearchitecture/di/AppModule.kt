package com.arjuntu90.samplearchitecture.di

import android.content.Context
import com.arjuntu90.logic.db.AppDatabase
import com.arjuntu90.samplearchitecture.MainApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun providesAppContext(@ApplicationContext mainApp: MainApp): Context =
        mainApp.applicationContext

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.buildDatabase(context)
}