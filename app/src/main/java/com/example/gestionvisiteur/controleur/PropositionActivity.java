package com.example.gestionvisiteur.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.gestionvisiteur.R;

public class PropositionActivity extends AppCompatActivity {
        Button ajout, consult, modifier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proposition);
        ajout = findViewById(R.id.btnAjout);
        consult = findViewById(R.id.btnConsult);
        modifier = findViewById(R.id.btnModifier);






        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(PropositionActivity.this, AjoutActivity.class);
                startActivity(intent3);

            }
        });

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(PropositionActivity.this, ConsultActivity.class);
                startActivity(intent3);

            }
        });

        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(PropositionActivity.this, ModifierActivity.class);
                startActivity(intent3);

            }
        });







    }
}