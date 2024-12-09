package edu.ucne.fitgoal.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.ucne.fitgoal.data.local.dao.CalendarioDao
import edu.ucne.fitgoal.data.local.dao.EjercicioDao
import edu.ucne.fitgoal.data.local.dao.EjerciciosPlantillasDao
import edu.ucne.fitgoal.data.local.dao.FitGoalDao
import edu.ucne.fitgoal.data.local.dao.HorarioBebidaDao
import edu.ucne.fitgoal.data.local.dao.PlantillaDao
import edu.ucne.fitgoal.data.local.dao.ProgresoUsuarioDao
import edu.ucne.fitgoal.data.local.dao.TipDao
import edu.ucne.fitgoal.data.local.dao.UsuarioDao
import edu.ucne.fitgoal.data.local.entities.CalendarioEntity
import edu.ucne.fitgoal.data.local.entities.EjercicioEntity
import edu.ucne.fitgoal.data.local.entities.FitGoalEntity
import edu.ucne.fitgoal.data.local.entities.UsuarioEntity
import edu.ucne.fitgoal.data.local.entities.PlantillaEntity
import edu.ucne.fitgoal.data.local.entities.EjerciciosPlantillasEntity
import edu.ucne.fitgoal.data.local.entities.HorarioBebidaEntity
import edu.ucne.fitgoal.data.local.entities.ProgresoUsuarioEntity
import edu.ucne.fitgoal.data.local.entities.TipEntity

@Database(
    entities = [
        FitGoalEntity::class,
        UsuarioEntity::class,
        CalendarioEntity::class,
        PlantillaEntity::class,
        EjercicioEntity::class,
        EjerciciosPlantillasEntity::class,
        HorarioBebidaEntity::class,
        TipEntity::class,
        ProgresoUsuarioEntity::class
               ],
    version = 25,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class FitGoalDb : RoomDatabase(){
    abstract fun fitGoalDao(): FitGoalDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun calendarioDao(): CalendarioDao
    abstract fun plantillaDao(): PlantillaDao
    abstract fun ejerciciosDao(): EjercicioDao
    abstract fun ejerciciosPlantillasDao(): EjerciciosPlantillasDao
    abstract fun horarioBebidaDao(): HorarioBebidaDao
    abstract fun tipDao(): TipDao
    abstract fun progresoUsuarioDao(): ProgresoUsuarioDao
}