package bj.myrilionne2002.triptravel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class AdapterFlipper_BaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<bj.myrilionne2002.triptravel.AdapterFlipperModel> models_list; //Nous écrivons l’entrée de baseadapter, c’est-à-dire que pour définir l’adaptateur, nous allons mettre une liste de tableaux et un contexte. Nous allons créer arraylist de l’ensemble des données dans l’activité principale.
    LayoutInflater inflater; //pour définir la disposition sur l’ adapterflipper

    public AdapterFlipper_BaseAdapter(@NonNull Context context, ArrayList<bj.myrilionne2002.triptravel.AdapterFlipperModel> models_list) {
        this.context = context;
        this.models_list = models_list;
        inflater = LayoutInflater.from(context.getApplicationContext()); //Initialisation de toutes les variables
    }

    @Override
    public int getCount() {
        return models_list.size(); //nombre d’éléments = no. d’éléments dans le model_list
    }

    @Override
    public Object getItem(int i) {
        return models_list.get(i); //sur le clic de l’élément, la position du model_list = getitem
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.homeadapterflipper, null); //nous avons défini la disposition du flipper. qui est le fichier homeadapterflipper que nous venons de créer!


        //Creation de variables
        ImageView picture, favourite;
        TextView name, state;

        //Affectation du contrôle aux variables

        picture = view.findViewById(R.id.adapterflipper_image);
        name = view.findViewById(R.id.adapterflipper_name);
        state = view.findViewById(R.id.adapterflipper_state);
        favourite = view.findViewById(R.id.adapterflipper_fav);

        //Affectation de valeurs aux variables

        bj.myrilionne2002.triptravel.AdapterFlipperModel model = models_list.get(i);

        name.setText(model.name);
        state.setText(model.state);
        picture.setImageResource(model.image);
        favourite.setImageResource(R.drawable.ic_baseline_favorite_24); //la même image serait dans toute la vue du flipper

           // Dans Adapterviewflipper et baseadapterclass, pour définir une police personnalisée, les paramètres suivants doivent être appliqués.
          //  nous allons créer 2 polices de caractères. un pour le latoblack et un pour le latobold.
         // latoblack serait pour le nom du lieu et latobold pour l’état.

        // Nous pouvons utiliser getResources au lieu de ResourcesCompat(). Cependant, j’ai utilisé ResourcesCompat() car il prend en charge ce paramètre de police dans tous les appareils.


        Typeface latoblack = ResourcesCompat.getFont(context, R.font.lato_black);
        Typeface latobold  = ResourcesCompat.getFont(context, R.font.lato_bold);

        name.setTypeface(latoblack);
        state.setTypeface(latobold);

        //Si nous exécutons l’application, le bouton fav serait invisible. pour le faire apparaître, nous allons l’ajouter dans cette adapterclass.

        return view;
    }
}
