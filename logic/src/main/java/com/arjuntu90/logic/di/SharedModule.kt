package com.arjuntu90.logic.di

import com.arjuntu90.logic.api.DataSourceApi
import com.arjuntu90.logic.db.AppDatabase
import com.arjuntu90.logic.domain.DefaultRepo
import com.arjuntu90.logic.model.weather.WeatherRepo
import com.arjuntu90.logic.util.NetworkUtils
import com.arjuntu90.shared.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SharedModule {
    @Provides
    @Singleton
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun providesGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun providesHttpRequestHandler(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): DataSourceApi = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .baseUrl(BuildConfig.BASE_URL)
        .build().create(DataSourceApi::class.java)

    @Provides
    @Singleton
    fun providesWeatherRepo(
        dataSourceApi: DataSourceApi,
        networkUtils: NetworkUtils,
        appDatabase: AppDatabase
    ): WeatherRepo = DefaultRepo(dataSourceApi, appDatabase, networkUtils)
}