package com.example.gestionvisiteur.controleur;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConsultActivity extends AppCompatActivity {
    ListView lesVisiteursListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        ArrayList<Visiteur> UnelisteVisiteur = new ArrayList<Visiteur>();

        VisiteurDAO LocataireDAO2 = new VisiteurDAO();
        UnelisteVisiteur = LocataireDAO2.recupVisiteur();



        lesVisiteursListView = findViewById(R.id.ListVisiteurs);
        ArrayAdapter monAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, UnelisteVisiteur);

        lesVisiteursListView.setAdapter(monAdapter);

        lesVisiteursListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Visiteur clickedItem = (Visiteur) lesVisiteursListView.getAdapter().getItem(position);
                Log.d("message","locataire"+clickedItem.getNom());
                Intent i = new Intent(ConsultActivity.this, DetailsActivity.class);
                Toast.makeText(ConsultActivity.this, "Le client choisi", Toast.LENGTH_LONG).show();

                i.putExtra("id", clickedItem.getIdVisiteur());
                i.putExtra("nom", clickedItem.getNom());
                i.putExtra("prenom", clickedItem.getPrenom());
                i.putExtra("login", clickedItem.getLogin());
                i.putExtra("mdp", clickedItem.getMdp());
                i.putExtra("adresse", clickedItem.getAdresse());
                i.putExtra("cp", clickedItem.getCp());
                i.putExtra("ville", clickedItem.getVille());
                i.putExtra("dateEmbauche", clickedItem.getDateEmbauche());

                startActivity(i);


            }
        });












    }
}