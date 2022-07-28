package com.example.android.gamesredo.di

import android.content.Context
import androidx.room.Room
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDao
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.models.TeamRecordsStandingsDtoMapper
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providesVenueDao(venueDatabase: VenueDatabase): VenueDao = venueDatabase.getDao()

    @Provides
    @Singleton
    fun provideVenueDatabase(@ApplicationContext context: Context): VenueDatabase
        = Room.databaseBuilder(
        context,
        VenueDatabase::class.java,
        "database"
    ).build()

    @Provides
    fun provideGameRepository(venueDb: VenueDatabase, api: MlbApi, @ApplicationContext context: Context, mapper: TeamRecordsStandingsDtoMapper) : GameRepository
        = GameRepository(venueDb, api, context, mapper)

    @Provides
    fun provideSportDtoMapper(): TeamRecordsStandingsDtoMapper
    =TeamRecordsStandingsDtoMapper()


    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()

    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): MlbApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MlbApi::class.java)

}






























