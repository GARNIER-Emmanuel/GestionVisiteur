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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AjoutActivity extends AppCompatActivity {
    TextView txtId, txtNom, txtPrenom, txtLogin, txtMdp, txtAdresse, txtCp ,txtVille ,txtDateEmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        Button btnAjoutVisiteur = (Button) findViewById(R.id.btnValiderAjout);

        txtId = findViewById(R.id.editTextId);
        txtNom = findViewById(R.id.editTextNom);
        txtPrenom = findViewById(R.id.editTextPrenom);
        txtLogin = findViewById(R.id.editTextLogin);
        txtMdp = findViewById(R.id.editTextMdp);
        txtAdresse = findViewById(R.id.editTextAdresse);
        txtCp = findViewById(R.id.editTextCp);
        txtVille = findViewById(R.id.editTextVille);
        txtDateEmb = findViewById(R.id.editTextDateEmb);

        btnAjoutVisiteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ajouterVisiteur();

            }
        });

        }

        private void ajouterVisiteur(){

            VisiteurDAO visiteurAcces = new VisiteurDAO();

            Visiteur newVisiteur = new Visiteur(txtId.getText().toString(),txtNom.getText().toString(),txtPrenom.getText().toString(),txtLogin.getText().toString(),txtMdp.getText().toString(),txtAdresse.getText().toString(),txtCp.getText().toString(),txtVille.getText().toString(),txtDateEmb.getText().toString());
            Log.d("visiteur", "********" + newVisiteur.toString());
            String result = visiteurAcces.addVisiteur(newVisiteur);

            if(result.equals("1\r")) {
                Context c = getApplicationContext();
                Toast msg = Toast.makeText(c, "ERREUR : Echec de l'ajout du client !", Toast.LENGTH_LONG);
                msg.show();
                Intent i = new Intent(AjoutActivity.this, PropositionActivity.class);
                startActivity(i);
            }else{
                Context c = getApplicationContext();
                Toast msg = Toast.makeText(c, "Le client a bien été ajouté !", Toast.LENGTH_LONG);
                msg.show();

            }

        }


}
