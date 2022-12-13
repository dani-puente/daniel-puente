package com.example.aplicacionciudades.di

import com.example.aplicacionciudades.model.consultaapidetail.DetailRepo
import com.example.aplicacionciudades.model.consultaapimain.FichasRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Con esto se le indica el alcance de esas instancias, si queremos que muera con la activity, que muera con el viewModel etc
@Module
@InstallIn(SingletonComponent::class)//Con esto se indica un alcance de aplicacion
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl("https://tuciudaddecerca-api.proconsi.com")
            .build()
    }

    @Singleton
    @Provides
    fun provideFichasRepo(retrofit: Retrofit): FichasRepo {
        return retrofit.create(FichasRepo::class.java)
    }

    @Singleton
    @Provides
    fun provideDetailRepo(retrofit: Retrofit): DetailRepo {
        return retrofit.create(DetailRepo::class.java)
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory{
        return GsonConverterFactory.create()
    }
}