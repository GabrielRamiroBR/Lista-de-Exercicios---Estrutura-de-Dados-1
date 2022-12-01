
public class Main
{
	public static void main(String args[])
	{
		ArvBinBusca<Integer, String> arvoreBinaria = new ArvBinBusca<>();
		
		arvoreBinaria.put(10, "Teste1");
		arvoreBinaria.put(20, "Teste2");
		arvoreBinaria.put(5, "Teste3");
		arvoreBinaria.put(2, "Teste4");
		arvoreBinaria.put(4, "Teste5");
		arvoreBinaria.put(18, "Teste6");
		arvoreBinaria.put(22, "Teste6");
		
		arvoreBinaria.mostra();
		
		System.out.println();
		
		System.out.println("O tamanho da árvore é: " + arvoreBinaria.tamanho());
		
		System.out.println("A altura da árvore é: " + arvoreBinaria.altura());
		
		System.out.println("A menor chave da árvore é: " + arvoreBinaria.min());
		
		System.out.println("A maior chave da árvore é: " + arvoreBinaria.max());
		
		if(arvoreBinaria.contem(18))
			System.out.println("O nó de chave 18 está contido na árvore.");
		else
			System.out.println("O nó de chave 18 não está contido na árvore.");
		
		if(arvoreBinaria.contem(23))
			System.out.println("O nó de chave 23 está contido na árvore.");
		else
			System.out.println("O nó de chave 23 não está contido na árvore.");
		
		arvoreBinaria.deleteMax();
		
		System.out.println("Impressão da árvore após remover o nó de maior chave:");
		
		arvoreBinaria.mostra();
		
		System.out.println();
		
		arvoreBinaria.delete(20);
		
		System.out.println("Impressão da árvore após remover o nó de chave 20:");
		
		arvoreBinaria.mostra();
	}
}
