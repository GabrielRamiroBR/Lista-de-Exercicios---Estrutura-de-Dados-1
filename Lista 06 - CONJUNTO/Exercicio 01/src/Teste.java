public class Teste {

    public static void main(String[] args) {
        ConjGenerico <Integer> c = new ConjGenerico<>();
        c.insere(0);
        c.insere(1);
        c.insere(2);
        c.insere(3);

        c.remove(0);
        c.remove(3);
        try {
            System.out.println(c.menor() + " / " + c.maior());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
