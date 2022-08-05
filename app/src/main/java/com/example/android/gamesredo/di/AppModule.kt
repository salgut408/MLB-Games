package com.example.android.gamesredo.di

import android.content.Context
import androidx.room.Room
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDao
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.models.*
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
    fun provideVenueDatabase(@ApplicationContext context: Context): VenueDatabase =
        Room.databaseBuilder(
            context,
            VenueDatabase::class.java,
            "database"
        ).build()

    @Provides
    fun provideGameRepository(
            venueDb: VenueDatabase,
            api: MlbApi,
            @ApplicationContext context: Context,
            teamRecordMapper: TeamRecordsStandingsDtoMapper,
            rosterDtoMapper: RosterDtoMapper,
            peopleDtoMapper: PeopleDtoMapper,
            gamesDtoMapper: GamesDtoMapper,
            leaderDtoMapper: LeadersDtoMapper,
            histDtoMapper: TeamsHistDtoMapper,
            gameDetailDtoMapper: GameDetailDtoMapper,
            gamePredictionDtoMapper: GamePredictionDtoMapper
    ): GameRepository = GameRepository(venueDb,
            api,
            context,
            teamRecordMapper,
            rosterDtoMapper,
            peopleDtoMapper,
            gamesDtoMapper,
            leaderDtoMapper,
             histDtoMapper,
        gameDetailDtoMapper,
        gamePredictionDtoMapper)

    @Provides
    fun provideLeaderDtoMapper(): LeadersDtoMapper = LeadersDtoMapper()

    @Provides
    fun provideGamePredictionMapper(): GamePredictionDtoMapper = GamePredictionDtoMapper()

    @Provides
    fun provideGamesDtoMapper(): GamesDtoMapper = GamesDtoMapper()

    @Provides
    fun provideGameDetailMapper(): GameDetailDtoMapper = GameDetailDtoMapper()

    @Provides
    fun provideSportDtoMapper(): TeamRecordsStandingsDtoMapper = TeamRecordsStandingsDtoMapper()

    @Provides
    fun provideTeamRosterDtoMapper(): RosterDtoMapper = RosterDtoMapper()

    @Provides
    fun providePeopleDtoMapper(): PeopleDtoMapper = PeopleDtoMapper()

    @Provides
    fun provideHistDtoMapper(): TeamsHistDtoMapper = TeamsHistDtoMapper()

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






























