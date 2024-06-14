package jorge.andaur.rios.pruebatdandroid3.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jorge.andaur.rios.pruebatdandroid3.R
import jorge.andaur.rios.pruebatdandroid3.databinding.FilaListaAnimalBinding
import jorge.andaur.rios.pruebatdandroid3.model.db.AnimalEntidad
import jorge.andaur.rios.pruebatdandroid3.view.DetalleAnimalFragment

class AnimalAdapter (private val listaAnimal: List<AnimalEntidad>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>(){

    class AnimalViewHolder(val binding: FilaListaAnimalBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimalViewHolder {
        val binding =
            FilaListaAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimal[position]
        holder.binding.txtNombreAnimal.text = animal.nombre
        holder.binding.txtTipo.text = animal.tipo
        holder.binding.txtColor.text = animal.color
        //Imagen
        Picasso.get()
            .load(animal.imagen)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.imgAnimal)
        //Configurar el click
        holder.binding.root.setOnClickListener {
            var detalle = DetalleAnimalFragment.newInstance(animal.id)
            val activity = it.context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction().replace(R.id.main, detalle)
                .addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return listaAnimal.size
    }


}