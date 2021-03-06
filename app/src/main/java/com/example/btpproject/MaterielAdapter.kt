package com.example.btpproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_mon_chantier.*

class MaterielAdapter(context: Context, resource: Int) : ArrayAdapter<Materiel>(context, resource) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v: View

        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v = layoutInflater.inflate(R.layout.activity_materiel_cellule, null)

        val materiel = getItem(position)
        val nom = v.findViewById<TextView>(R.id.nomTV)
        val type = v.findViewById<TextView>(R.id.typeTV)
        val date = v.findViewById<TextView>(R.id.dateTV)

        nom.text = materiel.nom
        type.text = materiel.type
        date.text = materiel.dateDemande


        return v
    }
}

