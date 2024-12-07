package edu.ucne.fitgoal.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import edu.ucne.fitgoal.data.local.database.FitGoalDb

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideFitGoalDb(@ApplicationContext appContext: Context) =
        Room.databaseBuilder(
            appContext,
            FitGoalDb::class.java,
            "FitGoal.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideFitGoalDao(fitGoalDb: FitGoalDb) = fitGoalDb.fitGoalDao()
    @Provides
    fun provideUsuarioDao(fitGoalDb: FitGoalDb) = fitGoalDb.usuarioDao()
    @Provides
    fun provideCalendarioDao(fitGoalDb: FitGoalDb) = fitGoalDb.calendarioDao()
    @Provides
    fun providePlantillaDao(fitGoalDb: FitGoalDb) = fitGoalDb.plantillaDao()
    @Provides
    fun provideEjerciciosDao(fitGoalDb: FitGoalDb) = fitGoalDb.ejerciciosDao()
    @Provides
    fun provideEjerciciosPlantillasDao(fitGoalDb: FitGoalDb) = fitGoalDb.ejerciciosPlantillasDao()
    @Provides
    fun provideHorarioBebidaDao(fitGoalDb: FitGoalDb) = fitGoalDb.horarioBebidaDao()
    @Provides
    fun provideTipDao(fitGoalDb: FitGoalDb) = fitGoalDb.tipDao()
    @Provides
    fun provideProgresoUsuarioDao(fitGoalDb: FitGoalDb) = fitGoalDb.progresoUsuarioDao()
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context): Context = context
}