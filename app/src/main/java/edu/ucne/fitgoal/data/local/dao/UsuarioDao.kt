package edu.ucne.fitgoal.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.fitgoal.data.local.entities.UsuarioEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Upsert
    suspend fun save(usuario: UsuarioEntity)

    @Query(
        """
        SELECT * 
        FROM Usuarios
        WHERE usuarioId = :id
        LIMIT 1
        """
    )
    suspend fun find(id: String): UsuarioEntity?

    @Query("SELECT * FROM Usuarios")
    fun getAll(): Flow<List<UsuarioEntity>>

    @Delete
    suspend fun delete(usuario: UsuarioEntity)
}
