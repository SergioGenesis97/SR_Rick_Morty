package mx.udg.alumnos.sr_rick_morty

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import mx.udg.alumnos.sr_rick_morty.model.Personaje

class ActivityDetalle : AppCompatActivity() {

    lateinit var ivPersonaje:ImageView
    lateinit var tvNombreDetalle:TextView
    lateinit var tvEspecie:TextView
    lateinit var tvEstatus:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle2)

        ivPersonaje = findViewById(R.id.ivPersonaje)
        tvNombreDetalle = findViewById(R.id.tvNombreDetalles)
        tvEspecie = findViewById(R.id.tvEspecie)
        tvEstatus = findViewById(R.id.tvEstatus)

        val data = intent.getParcelableExtra<Personaje>("personaje")

        Picasso.get().load(data!!.imagen).into(ivPersonaje)

        tvNombreDetalle.text = data.Nombre
        tvEspecie.text = data.especie

        when(data.status){
            "Alive"-> tvEstatus.setTextColor(Color.GREEN)
            "Dead"-> tvEstatus.setTextColor(Color.RED)
            "unknown"-> tvEstatus.setTextColor(Color.YELLOW)
        }

        tvEstatus.text = data.status




    }
}