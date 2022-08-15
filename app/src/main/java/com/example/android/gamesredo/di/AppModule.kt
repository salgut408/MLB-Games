package com.example.android.gamesredo.di

import android.content.Context
import androidx.room.Room
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.Converters
import com.example.android.gamesredo.db.standingsdb.StandingsDao
import com.example.android.gamesredo.db.standingsdb.StandingsDatabase
import com.example.android.gamesredo.db.venuedb.VenueDao
import com.example.android.gamesredo.db.venuedb.VenueDatabase
import com.example.android.gamesredo.db.todaysgamesdb.TodaysGamesDao
import com.example.android.gamesredo.db.todaysgamesdb.TodaysGamesDatabase
import com.example.android.gamesredo.models.*
import com.example.android.gamesredo.models.contentresponspkg.ContentResponseDtoMapper
import com.example.android.gamesredo.models.playbyplay.json2kt_Kotlin_07.PlayByPlayDtoMapper
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
    fun providesTodaysGamesDao(todaysGamesDatabase: TodaysGamesDatabase): TodaysGamesDao = todaysGamesDatabase.getTodaysGamesDao()

    @Provides
    @Singleton
    fun provideTodaysGamesDatabase(@ApplicationContext context: Context): TodaysGamesDatabase =
        Room.databaseBuilder(
            context,
            TodaysGamesDatabase::class.java,
            "Todays_Games"
        ).build()

    @Provides
    fun providesStandingsDao(standingsDatabase: StandingsDatabase): StandingsDao = standingsDatabase.getStandingsDao()

    @Provides
    @Singleton
    fun provideStandingsDatabase(@ApplicationContext context: Context) : StandingsDatabase =

        Room.databaseBuilder(
            context,
            StandingsDatabase::class.java,
            "Standings"
        )


            .build()

    @Provides
    fun provideGameRepository(
        standingsDatabase: StandingsDatabase,
        todaysGamesDatabase: TodaysGamesDatabase,
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
        gamePredictionDtoMapper: GamePredictionDtoMapper,
        gameContentResponseDtoMapper: ContentResponseDtoMapper,
        playByPlayDtoMapper: PlayByPlayDtoMapper
    ): GameRepository = GameRepository(
        standingsDatabase,
        todaysGamesDatabase,
        venueDb,
            api,
            context,
            teamRecordMapper,
            rosterDtoMapper,
            peopleDtoMapper,
            gamesDtoMapper,
            leaderDtoMapper,
             histDtoMapper,
        gameDetailDtoMapper,
        gamePredictionDtoMapper,
        gameContentResponseDtoMapper,
        playByPlayDtoMapper
    )

    @Provides
    fun providePlayByPlayMApper(): PlayByPlayDtoMapper = PlayByPlayDtoMapper()

    @Provides
    fun provideContentMapper(): ContentResponseDtoMapper = ContentResponseDtoMapper()
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






























