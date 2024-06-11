package jorge.andaur.rios.pruebatdandroid3

import android.app.Application
import androidx.room.Room
import jorge.andaur.rios.pruebatdandroid3.model.db.AppDatabase


class ClaseApp : Application() {

    companion object {
        //Base de datos
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        // Configurar la base de datos Room
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "bd_animales"
        ).build()
    }
}