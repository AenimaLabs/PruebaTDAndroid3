package jorge.andaur.rios.pruebatdandroid3.model.network

import jorge.andaur.rios.pruebatdandroid3.model.AnimalDetailModel
import jorge.andaur.rios.pruebatdandroid3.model.AnimalModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interfaz que va a tener las Apis que vamos a usar
 */
interface ApiService {
    //Listado de empresas
    @GET("animales")
    fun obtenerAnimales(): Call<List<AnimalModel>>

    //Detalle de empresas
    @GET("animales/{id_animal}") //https://retoolapi.dev/cluuwe/empresas/9
    fun detalleAnimal(@Path("id_animal") animalCargar: Int): Call<AnimalDetailModel>
}