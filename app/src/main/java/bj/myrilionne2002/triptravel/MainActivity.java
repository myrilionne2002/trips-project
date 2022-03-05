
package bj.myrilionne2002.triptravel;


import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdapterViewFlipper flipper;
    ArrayList<bj.myrilionne2002.triptravel.AdapterFlipperModel> flipper_data;
    AdapterFlipper_BaseAdapter flipper_baseadapter;

    CardView pendjari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = findViewById(R.id.adapter_flipper_home); //palmer principal de la maison qui serait montré dans l’application

        flipper_data = new ArrayList<>();

        //Ajout d’éléments à flipper_data dans liste de tableaux.
        flipper_data.add(new bj.myrilionne2002.triptravel.AdapterFlipperModel("Parc  de Pendjari", "Tanguiéta", R.drawable.Pendjari)); //définition de valeurs pour les éléments qui se trouvaient dans le constructeur de la classe java  du model adpater .
        flipper_data.add(new bj.myrilionne2002.triptravel.AdapterFlipperModel("La place nonvitcha", "nonvitcha", R.drawable.nonvitcha));
        flipper_data.add(new bj.myrilionne2002.triptravel.AdapterFlipperModel("Toffa 1er", "Porto-Novo", R.drawable.ima2));
        flipper_data.add(new bj.myrilionne2002.triptravel.AdapterFlipperModel("Route des peches", "Fridrossè", R.drawable.ima1));
        flipper_data.add(new bj.myrilionne2002.triptravel.AdapterFlipperModel("Palais Royaux d'Abomey", "Abomey", R.drawable.Abomey));

        //Réglage de l’adaptateur
        flipper_baseadapter = new AdapterFlipper_BaseAdapter(this, flipper_data);
        flipper.setAdapter(flipper_baseadapter);

        //quelques de paramètres pour contrôler le flipper
        flipper.setAutoStart(true); //démarrer lorsque l’application démarre sans que l’utilisateur ne clique dessus.
        flipper.setFlipInterval(3000); //3000 milliseconds = 3 seconds.

        pendjari  = findViewById(R.id.pendjari);
        pendjari.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, City_Information.class)));

    }
}