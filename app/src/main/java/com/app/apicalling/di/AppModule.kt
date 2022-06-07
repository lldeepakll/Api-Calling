package com.app.apicalling.di

import com.app.apicalling.BuildConfig
import com.app.apicalling.data.network.RestApi
import com.app.apicalling.data.remote.MoviesRemoteDataSource
import com.app.apicalling.data.remote.MoviesRemoteDataSourceImpl
import com.app.apicalling.repository.MoviesRepository
import com.app.apicalling.repository.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// @Module annotation which will make this class a module
// to inject dependency to other class within it's scope.
// @InstallIn(SingletonComponent::class) this will make
// this class to inject dependencies across the entire application.
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://60d194a45b017400178f3e51.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestApi(retrofit: Retrofit): RestApi {
        return retrofit.create(RestApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")
                }.build())
            }.also { client ->
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }.build()
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(impl: MoviesRemoteDataSourceImpl): MoviesRemoteDataSource {
        return impl
    }

    @Provides
    @Singleton
    fun provideMovieRepo(impl: MoviesRepositoryImpl): MoviesRepository {
        return impl
    }

}
