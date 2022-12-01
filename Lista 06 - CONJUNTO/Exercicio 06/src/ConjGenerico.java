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

	/* Exercicio 06
Complexidade O(n) pois percorre os conjuntos apenas 1 vez indo até o elemento n onde n = tamanho do menor conjunto
 */
	public boolean eIgual(ConjGenerico<T> conj2){
		Elo p = prim, q = conj2.prim;

		return eIgual(p, q);
	}
	private boolean eIgual(Elo p, Elo q){
		if (q == null && p == null)
			return true;
		else
			if ((p == null && q != null) || (p != null && q == null) || (p.dado.compareTo(q.dado) != 0))
				return false;
		p = p.prox;
		q = q.prox;

		return eIgual(p, q);
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