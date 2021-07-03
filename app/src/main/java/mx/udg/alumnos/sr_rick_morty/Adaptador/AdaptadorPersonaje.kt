package mx.udg.alumnos.sr_rick_morty.Adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.udg.alumnos.sr_rick_morty.ActivityDetalle
import mx.udg.alumnos.sr_rick_morty.R
import mx.udg.alumnos.sr_rick_morty.model.Personaje

class AdaptadorPersonaje(personajes:ArrayList<Personaje>,
                         ctx:Context):RecyclerView.Adapter<AdaptadorPersonaje.ViewHolder>() {

    lateinit var personajes: ArrayList<Personaje>
    lateinit var ctx: Context

    init {
        this.ctx = ctx
        this.personajes = personajes

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vistaPersonaje = LayoutInflater.from(ctx).inflate(R.layout.tarjeta_personaje,
                                                              parent, false)
        val personajeViewHolder = ViewHolder(vistaPersonaje)
        vistaPersonaje.tag = personajeViewHolder
        return personajeViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = personajes[position].Nombre
        Picasso.get().load(personajes[position].imagen).into(holder.ivFoto)
        holder.ibDetalle.setOnClickListener {
            val i = Intent(ctx, ActivityDetalle::class.java)
            i.putExtra("personaje", personajes[position])
            ctx.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    class ViewHolder(vistaIndividual:View):RecyclerView.ViewHolder(vistaIndividual){
        lateinit var ivFoto:ImageView
        lateinit var tvNombre:TextView
        lateinit var ibDetalle:ImageButton

        init {
            ivFoto = vistaIndividual.findViewById(R.id.ivAvatar)
            tvNombre = vistaIndividual.findViewById(R.id.tvNombre)
            ibDetalle = vistaIndividual.findViewById(R.id.ibDetalles)
        }
    }
}