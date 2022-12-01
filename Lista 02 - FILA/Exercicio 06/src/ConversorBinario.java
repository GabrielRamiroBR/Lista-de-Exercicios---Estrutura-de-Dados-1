public class ConversorBinario {

    public static String converteBinario (int n){
        /* calcula a quantidade de bits necessários
        para representar um numero decimal em binário */
        int tamanho  = (int) Math.ceil(Math.log10(n + 1)/Math.log10(2));
        String binario = "";

        FilaDupla fila = new FilaDupla(tamanho);

        while (n > 0){
            fila.insere(n % 2);
            n /= 2;
        }
        while (!fila.vazia()){
            binario += Integer.toString(fila.removeFim());
        }

        return binario;
    }

    public static void imprimeBinariosAteN(int n){

        for (int i = 0; i <= n; i++){
            System.out.printf(converteBinario(i) + " ");
        }
    }
}
