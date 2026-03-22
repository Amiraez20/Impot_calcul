package com.example.impots_calcul;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText givensurface, givenpieces;
    private CheckBox checkboxpool;
    private TextView resultatsvue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        givensurface = findViewById(R.id.given_surface);
        givenpieces = findViewById(R.id.given_pieces);
        checkboxpool = findViewById(R.id.yesorno_piscine);
        resultatsvue = findViewById(R.id.resultats);

        findViewById(R.id.bouton_calcul).setOnClickListener(v -> calcul());
    }

    private void calcul() {
        double sur_face = Double.parseDouble(givensurface.getText().toString());
        int Pieces = Integer.parseInt(givenpieces.getText().toString());
        boolean pool = checkboxpool.isChecked();

        double impot_Base = sur_face * 2;
        double supplements = Pieces * 50 + (pool ? 100 : 0);
        double total_Imp = impot_Base + supplements;

        resultatsvue.setText("le total d'Impôt est : " + total_Imp + " DHs");
    }
}