package bj.myrilionne2002.triptravel;

public class AdapterFlipperModel {

    String name, state; //il ne s’agit que d’une chaîne, pas d’un tableau. Si vous utilisez un adaptateur de tableau dans adapterviewflipper, vous devez utiliser String[] pour  rendre le tableau.
    Integer image; //nous allons appliqué la meme chose .

    //Nous allons créer constructeur, getter pour obtenir les variables et setter pour définir la valeur des variables.


    public AdapterFlipperModel(String name, String state, Integer image) {
        this.name = name;
        this.state = state;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public Integer getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

}
