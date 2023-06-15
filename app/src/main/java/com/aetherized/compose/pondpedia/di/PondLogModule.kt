package com.aetherized.compose.pondpedia.di

import android.app.Application
import androidx.room.Room
import com.aetherized.compose.pondpedia.data.local.Converters
import com.aetherized.compose.pondpedia.data.local.database.PondDatabase
import com.aetherized.compose.pondpedia.data.remote.api.PondApi
import com.aetherized.compose.pondpedia.data.repository.PondLogRepositoryImpl
import com.aetherized.compose.pondpedia.data.util.GsonParser
import com.aetherized.compose.pondpedia.domain.repository.PondLogRepository
import com.aetherized.compose.pondpedia.domain.use_case.GetPondLogById
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PondLogModule {

    @Provides
    @Singleton
    fun provideGetPondLogUseCase(repository: PondLogRepository): GetPondLogById {
        return GetPondLogById(repository)
    }

    @Provides
    @Singleton
    fun providePondLogRepository(
        db: PondDatabase,
        api: PondApi,
    ): PondLogRepository {
        return PondLogRepositoryImpl(api, db.pondLogDao)
    }

    @Provides
    @Singleton
    fun providePondDatabase(app: Application): PondDatabase {
        return Room.databaseBuilder(
            app,
            PondDatabase::class.java,
            "pond_database_v1.0"
        ).addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun providePondApi(): PondApi {
        return Retrofit.Builder()
            .baseUrl(PondApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PondApi::class.java)
    }
}