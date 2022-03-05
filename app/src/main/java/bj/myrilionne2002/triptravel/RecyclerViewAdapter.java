package bj.myrilionne2002.triptravel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
//objectif
 //création  de l'adaptateur lié a votre vue
//ce fichier java va remplir les TextView, ImageView et  RatingBar avec comme texte ,image et Rating leurs positions dans la grille
// Cet adaptateur intègre également la gestion des clics sur les élements de la grille


//fournir une references aux vues pour chaque élément de la données
// les éléments de  données complexes peuvent necessiter plus d'une vues par élément,et
//vous donnez accès à toutes les vues d'un  élément de  données dans un detenteur de vues

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context mycontext;
    ArrayList<RecyclerViewModel> recycler_model_list;
    // les données de la grille sont passées en paramètre au constructeur de la classe

    public RecyclerViewAdapter(Context mycontext, ArrayList<RecyclerViewModel> recycler_model_list) {
        this.mycontext = mycontext;
        this.recycler_model_list = recycler_model_list;
    }

     //3onCreateViewHolder crée un nouvel objet ViewHolder a chaque fois que RecyclerView en a besoin d'un nouveau
     //2met en places l'affichage de la vue a partir des éléments des fichiers XML
     //1créer une nouvelle vues (invoquées par le gestionnaire de mise en page)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        @SuppressLint("InflateParams") View layout_view = LayoutInflater.from(mycontext.getApplicationContext()).inflate(R.layout.city_attractions_list_layout, null);
        return new ViewHolder(layout_view);

    }
     //méthodes qui remplit la "name_txt"avec la donnée name
    //méthodes qui remplit la "distance_txt"avec la donnée distance
    //méthodes qui remplit la "image"avec la donnée image
    //méthodes qui remplit la "rating"avec la donnée rating
    //name_txt et distance_txt étant des  TextView, image étant un ImageView et rating étant un  RatingBar
    // la fonction onBindViewHolder est appelé pour mettre a jour un RecyclerView ou pour en créer un nouveau
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewModel
                // recuperer les informations du recycler
                model = recycler_model_list.get(position);
       //mettre à jour des données
        holder.name_txt.setText(model.name);
        holder.distance_txt.setText(model.distance);
        holder.image.setImageResource(model.image);
        holder.rating.setRating(model.rating);
    }
    //méthodes comptant le nbre total de cellule
    @Override
    public int getItemCount() {
        return recycler_model_list.size();
    }
     //initialisation des vues
    //méthodes qui stocke et réutilise les cellules au fur et a mesure du defilement de l'ecran
     //le ViewHolder(RecyclerView.ViewHolder) est utilisé pour définir chaque élément individuel de la liste de données dans le RecyclerView
     public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_txt, distance_txt;
        ImageView image;
        RatingBar rating;
         //chaque élément de  données est juste une chaine dans ce cas
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_txt = itemView.findViewById(R.id.recycler_name);
            distance_txt = itemView.findViewById(R.id.recycler_distance);
            image = itemView.findViewById(R.id.recycler_image);
            rating = itemView.findViewById(R.id.recycler_rating);

            Typeface lato_black = ResourcesCompat.getFont(mycontext, R.font.lato_black);
            Typeface lato_bold = ResourcesCompat.getFont(mycontext, R.font.lato_bold);

            name_txt.setTypeface(lato_black);
            distance_txt.setTypeface(lato_bold);

        }
    }
}
