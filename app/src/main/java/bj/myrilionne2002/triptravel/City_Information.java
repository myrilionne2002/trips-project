package bj.myrilionne2002.triptravel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class City_Information extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;//affiche les elememts dans une liste de défilement horizontal ou vertical en d'autre termes organise disposition des données
    ArrayList<bj.myrilionne2002.triptravel.RecyclerViewModel> list = new ArrayList<>();
    bj.myrilionne2002.triptravel.RecyclerViewItemDecoration decoration;//aidera a dessiner  tout le decor et a ne pas reproduire des vues inutiles dans la disposition des cellulles et de l'écran
    //fonction permettant d/injecter le contenu du RecyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //quand le City_Information sera créer il va venir appelé la fonction onCreateView qui va venir injecter le contenue de activity_city_information sur la page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_information);

        ///// RECYCLER VIEW :

        list.add(new bj.myrilionne2002.triptravel.RecyclerViewModel("Musée d'histoire de Ouidah", "2 km", R.drawable.ouidah, 4.5f));
        list.add(new bj.myrilionne2002.triptravel.RecyclerViewModel("Palais Royaux d'Abomey", "28 km", R.drawable.Abomey, 4f));
        list.add(new bj.myrilionne2002.triptravel.RecyclerViewModel("Place Nonvitcha", "2 km", R.drawable.nonvitcha, 4.5f));
        list.add(new bj.myrilionne2002.triptravel.RecyclerViewModel("Toffa 1er", "3 km", R.drawable.ima2, 3f));

        recyclerView = findViewById(R.id.recyclerView);

        bj.myrilionne2002.triptravel.RecyclerViewAdapter adapter = new bj.myrilionne2002.triptravel.RecyclerViewAdapter(this, list);
        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        decoration = new bj.myrilionne2002.triptravel.RecyclerViewItemDecoration(16);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(decoration);

    }
}