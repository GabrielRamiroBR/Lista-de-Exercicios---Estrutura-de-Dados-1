public class Diretório extends Lista {

    protected Lista dado;
    protected Lista.Elo prox;

    @Override
    public boolean isArquivo() {
        return false;
    }
}
