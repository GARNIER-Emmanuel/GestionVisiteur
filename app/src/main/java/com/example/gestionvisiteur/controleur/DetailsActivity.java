package com.example.gestionvisiteur.controleur;

import androidx.appcompat.app.AppCompatActivity;
import com.example.gestionvisiteur.R;
import com.example.gestionvisiteur.modele.Visiteur;
import com.example.gestionvisiteur.modele.VisiteurDAO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private Button buttonModifierV, buttonSupprimer;
    private EditText editTextIdV, editTextNomV, editTextPrenomV, editTextloginV, editTextmdpV, editTextAdresseV, editTextcpV,editTextvilleV ,editTextdateEmbaucheV;
    private ArrayList<Visiteur> listeVisiteur;
    private VisiteurDAO recupVisiteur;
    private Visiteur unVisiteur;
    private String id, nom, prenom, login, mdp, adresse, cp, ville, dateEmbauche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        editTextIdV = findViewById(R.id.editTextId);
        editTextNomV = findViewById(R.id.editTextNom);
        editTextPrenomV = findViewById(R.id.editTextPrenom);
        editTextloginV = findViewById(R.id.editTextLogin);
        editTextmdpV = findViewById(R.id.editTextMdp);
        editTextAdresseV = findViewById(R.id.editTextAdresse);
        editTextcpV = findViewById(R.id.editTextCp);
        editTextvilleV = findViewById(R.id.editTextVille);
        editTextdateEmbaucheV = findViewById(R.id.editTextDateEmb);


        id = getIntent().getStringExtra("id");
        nom = getIntent().getStringExtra("nom");
        prenom = getIntent().getStringExtra("prenom");
        login = getIntent().getStringExtra("login");
        mdp = getIntent().getStringExtra("mdp");
        adresse = getIntent().getStringExtra("adresse");
        cp = getIntent().getStringExtra("cp");
        ville = getIntent().getStringExtra("ville");
        dateEmbauche = getIntent().getStringExtra("dateEmbauche");

        editTextIdV.setText(id);
        editTextNomV.setText(nom);
        editTextPrenomV.setText(prenom);
        editTextloginV.setText(login);
        editTextmdpV.setText(mdp);
        editTextAdresseV.setText(adresse);
        editTextcpV.setText(cp);
        editTextvilleV.setText(ville);
        editTextdateEmbaucheV.setText(dateEmbauche);


        buttonModifierV =findViewById(R.id.btnValiderAjout);
        buttonModifierV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                VisiteurDAO visiteurDAO = new VisiteurDAO();
                String resId = editTextIdV.getText().toString();
                String resNom = editTextNomV.getText().toString();
                String resPrenom = editTextPrenomV.getText().toString();
                String resLogin = editTextloginV.getText().toString();
                String resMdp = editTextmdpV.getText().toString();
                String resAdresse = editTextAdresseV.getText().toString();
                String resCp = editTextcpV.getText().toString();
                String resVille = editTextvilleV.getText().toString();
                String resDateEmbauche = editTextdateEmbaucheV.getText().toString();

                Visiteur leNouveauVisiteur = new Visiteur(resId,resNom, resPrenom, resLogin, resMdp, resAdresse, resCp, resVille, resDateEmbauche);
                String res = visiteurDAO.modifierVisiteur(leNouveauVisiteur, id);

                if (res.equals("true")){
                    Toast.makeText(getApplicationContext(), "Echec de la modification !", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Modification réussi !", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(DetailsActivity.this, ConsultActivity.class);
                    startActivity(i);
                }

            }

        });

        buttonSupprimer =findViewById(R.id.btnSuppr);
        buttonSupprimer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                VisiteurDAO visiteurDAO = new VisiteurDAO();
                String idS = editTextIdV.getText().toString();

                String res = visiteurDAO.suppVisiteur(idS);

                if (res.equals("1\r")){
                    Toast.makeText(getApplicationContext(), "Echec de la modification !", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Modification réussi !", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(DetailsActivity.this, ConsultActivity.class);
                    startActivity(i);

                }

            }

        });
    }
}