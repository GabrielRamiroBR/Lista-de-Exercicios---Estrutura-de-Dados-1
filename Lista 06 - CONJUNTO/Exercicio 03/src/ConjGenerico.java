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

	/* Exercicio 03
	Complexidade O(n.m) pois percorre os dois conjuntos por inteiro
	 */
	public ConjGenerico<T> complementar(ConjGenerico<T> universo) throws Exception {
		ConjGenerico<T> complementar = new ConjGenerico<>();

		/*copia o universo para conjunto complementar*/
		Elo ult = null, q;

		for (Elo p = universo.prim; p != null; p = p.prox) {
			q = new Elo(p.dado);

			if (ult == null)
				complementar.prim = q;
			else
				ult.prox = q;

			ult = q;
		}

		/* Verifica se todos os elos do conjunto corrente pertence ao univero e lança uma exceção se não pertencer.
		 * Ao mesmo tempo que remove do complementar todos os elos que pertencem tanto ao conjunto corrente
		 *  quanto ao complementar, sobrando no final apenas o complementar de fato.*/

		for (Elo p = prim; p != null; p = p.prox){
			Elo prev = null, k = complementar.prim;

			while ((k != null) && (k.dado.compareTo(p.dado) <= 0)){
				if (k.dado.compareTo(p.dado) == 0){
					if (k == complementar.prim)
						complementar.prim = k.prox;
					else
						prev.prox = k.prox;
				}
				prev = k;
				k = k.prox;
			}
			if (prev.dado.compareTo(p.dado) != 0)
				throw new Exception("conjunto corrente não pertence ao universo");
		}
		return complementar;
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