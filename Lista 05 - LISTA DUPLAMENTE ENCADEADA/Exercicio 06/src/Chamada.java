public class Chamada {
    private String numero;
    private boolean longe;

    public Chamada(String numero, boolean longe) {
        this.numero = numero;
        this.longe = longe;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isLonge() {
        return longe;
    }
}
