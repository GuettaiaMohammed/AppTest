package com.example.btpproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_liste_materiels.*
import kotlinx.android.synthetic.main.activity_mon_chantier.*

import java.util.ArrayList


class ListeMaterielsActivity : AppCompatActivity() {

    private var mesMateriels: ArrayList<Materiel>? = null
    private var listView: ListView? = null
    private var materielAdapter: MaterielAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_liste_materiels)

        val toolbar = findViewById<Toolbar>(R.id.toolbarMateriel)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Matériels")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        listView = findViewById(R.id.materielListe)
        materielAdapter = MaterielAdapter(applicationContext, 0)

        mesMateriels = ArrayList();

        (mesMateriels as ArrayList<Materiel>).add(Materiel("Grue", "liebherr/Flat-Top EC-B/Pas de Plaque", "11/03/2020"))
        (mesMateriels as ArrayList<Materiel>).add(Materiel("Grue", "liebherr/Flat-Top EC-B/Pas de Plaque", "11/03/2020"))
        (mesMateriels as ArrayList<Materiel>).add(Materiel("Grue", "liebherr/Flat-Top EC-B/Pas de Plaque", "11/03/2020"))
        (mesMateriels as ArrayList<Materiel>).add(Materiel("Grue", "liebherr/Flat-Top EC-B/Pas de Plaque", "11/03/2020"))

        materielAdapter!!.addAll(mesMateriels)
        listView!!.adapter = materielAdapter

        var i:Int = 0
        listView!!.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, position, l ->
            for (i in 0..mesMateriels!!.size) {
                if (position == i) {
                    val intent = Intent(this, DetailMaterielActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }
            }

        })

        //button click to show dialog
        fabMateriel.setOnClickListener {
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_ajouter_materiel, null)
            //AlertDialogBuilder
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
            //.setTitle("Login Form")
            //show dialog
            mBuilder.show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.navigation_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when{
            item!!.getItemId() == R.id.navigation_home ->
            {
                val intent = Intent(this, MonChantier::class.java)
                // start your next activity
                startActivity(intent)
                return true
            }
            item!!.getItemId() == R.id.navigation_dashboard ->
            {
                val intent = Intent(this, MainActivity::class.java)
                // start your next activity
                startActivity(intent)
                return true
            }
            item!!.getItemId() == R.id.navigation_materiel ->
            {
                val intent = Intent(this, ListeMaterielsActivity::class.java)
                // start your next activity
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
