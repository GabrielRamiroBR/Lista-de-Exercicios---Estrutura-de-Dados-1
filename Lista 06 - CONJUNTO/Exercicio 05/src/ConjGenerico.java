public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;  /* Referência para primeiro elemento. */

	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo
	{                 
		T dado;
		Elo prox;

		public Elo()
		{ 
			prox = null;
		}

		public Elo(T elem)
		{
			dado = elem;
			prox = null;
		}

		public Elo(T elem, Elo proxElem)
		{ 
			dado = elem;
			prox = proxElem;
		}
	}

	/* Construtor que cria um conjunto vazio. */
	public ConjGenerico()
	{
		prim = null;
	}

	/*Exercicio 05
	Complexidade O(n.m) pois percorre os dois conjuntos por inteiro
	 */
	public ConjGenerico<T> diferenca(ConjGenerico<T> conj2) {
		ConjGenerico<T> diferenca = new ConjGenerico();
		Elo q, ant = null;
		for (Elo p = prim; p != null; p = p.prox) {
			for (q = conj2.prim; ((q != null) && (q.dado.compareTo(p.dado)) < 0); q = q.prox);

			if (q == null || p.dado.compareTo(q.dado) != 0) {
				Elo k = new Elo(p.dado);

				if (diferenca.prim == null)
					diferenca.prim = k;
				else
					ant.prox = k;
				ant = k;

			}
		}
		return diferenca;
	}

	public boolean insere(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) == 0) return false;
			if (p.dado.compareTo(valor) > 0) break;

			ant = p;
		}

		Elo q = new Elo(valor);

		if (p == prim)
			prim = q;
		else
			ant.prox = q;

		q.prox = p;

		return true;
	}



	/* Imprime todos os elementos do conjunto */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos do conjunto");
		
		for(p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");
		
		System.out.println();
	}
}