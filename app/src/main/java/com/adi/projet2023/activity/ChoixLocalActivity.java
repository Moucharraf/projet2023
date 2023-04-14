package com.adi.projet2023.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.adi.projet2023.R;
import com.adi.projet2023.adapter.AdapterChoixLocal;
import com.adi.projet2023.databinding.ActivityChoixLocalBinding;
import com.adi.projet2023.model.local.AutreLocal;
import com.adi.projet2023.model.local.Entreprise;
import com.adi.projet2023.model.local.Local;
import com.adi.projet2023.model.local.Maison;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ChoixLocalActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityChoixLocalBinding binding;
    ListView listLocaux;
    List<Local> lesLocaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChoixLocalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lesLocaux= List.of(new Maison("maison secondaire", "Cite El khadra", "Tunis"),
                            new AutreLocal("jardin", "Île de Nice", "Djerba"),
                            new Maison("maison Parents", "Cite caisse", "Mahdia"),
                            new Entreprise("Fac des sciences", "Cite el Omrane", "Monastir"),
                            new Maison ("maison copine", "avenue CDG", "Paris"));

        AdapterChoixLocal adapterChoixLocal= new AdapterChoixLocal(this, lesLocaux);
        listLocaux.setAdapter(adapterChoixLocal);
    }

    /**
     * Initialisation des composants
     */
    private void init(){
        listLocaux= findViewById(R.id.listChoixLocal);
        lesLocaux= new ArrayList<>();
    }


}