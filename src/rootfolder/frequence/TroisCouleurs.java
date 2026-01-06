package frequence;

//objet pour acceder au 3 tableaux de couleur

public class TroisCouleurs {
    private int[] rouge;
    private int[] vert;
    private int[] bleu;

    public TroisCouleurs(int[] r, int[] g, int[] b) {
        this.rouge = r;
        this.vert = g;
        this.bleu = b;
    }

    public int[] getRouge(){
        return this.rouge;
    }

    public int[] getVert(){
        return this.vert;
    }

    public int[] getBleu(){
        return this.bleu;
    }
}