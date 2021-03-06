package com.example.btpproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_liste_ordre_de_travail.*
import java.util.ArrayList

class ListeOrdreDeTravailActivity : AppCompatActivity() {

    private var listOT: MutableList<OrdreDeTravail>? = null
    private var listView: ListView? = null
    private var ordreTravailAdapter: OrdreDeTravailAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_ordre_de_travail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle("Ordres de travail")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        listView = findViewById(R.id.ordreDeTravailListe)
        listOT = ArrayList()

        listOT!!.add(OrdreDeTravail("Ordre de travail 1", "lot 1"))
        listOT!!.add(OrdreDeTravail("Ordre de travail 1", "lot 1"))
        listOT!!.add(OrdreDeTravail("Ordre de travail 1", "lot 1"))
        listOT!!.add(OrdreDeTravail("Ordre de travail 1", "lot 1"))

        ordreTravailAdapter = OrdreDeTravailAdapter(applicationContext, 0)
        listView!!.adapter = ordreTravailAdapter
        ordreTravailAdapter!!.addAll(listOT)

        var i:Int = 0
        listView!!.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, position, l ->
            for (i in 0..listOT!!.size) {
                if (position == i) {
                    val intent = Intent(this, DetailOrdreDeTravail::class.java)
                    // start your next activity
                    startActivity(intent)
                }
            }

        })

        //button click to show dialog
        fabOrdreDeTravail.setOnClickListener {
            //Inflate the dialog with custom view
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_ajouter_ordre_de_travail, null)
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
