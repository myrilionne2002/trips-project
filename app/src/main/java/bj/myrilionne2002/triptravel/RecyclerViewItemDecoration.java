package bj.myrilionne2002.triptravel;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//méthodes qui nous aidera dessiner  tout le decor et a ne pas reproduire des vues inutiles dans la disposition des cellulles et de l'écran
public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration {
    int margin;

    public RecyclerViewItemDecoration(int margin) {
        this.margin = margin;
    }
//methode d'indentation de ViewHolder lors du remplissage du RecyclerView par la signature des onDraw*
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.right = margin;
    }
}
