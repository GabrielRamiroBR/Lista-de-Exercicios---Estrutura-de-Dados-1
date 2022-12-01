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

	/* Exercicio 02
	Complexidade O(n) pois percorre apenas uma vez o conjunto
	 */
	public boolean eIgual(ConjGenerico<T> conj2){
		Elo p = prim, q = conj2.prim;
		while (p != null || q != null){
			if (p.dado.compareTo(q.dado) != 0)
				return false;
			p = p.prox;
			q = q.prox;
		}
		return true;
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