package com.example.gestionvisiteur.controleur;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.gestionvisiteur.R;

public class MainActivity extends AppCompatActivity {
    Button valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valider = findViewById(R.id.btnValider);





        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, PropositionActivity.class);
                startActivity(intent3);

            }
        });

    }
}