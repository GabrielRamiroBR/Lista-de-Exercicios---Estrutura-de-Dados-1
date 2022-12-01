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

	/* Exercicio 07
	Complexidade O(n.m) complexidade do método complementar
	É necessário haver um conjunto universo para se calcular o complementar, então botei ele como parâmetro
	Além de mudar o método para não estático pois a linguagem não estava permitindo
 */
	public ConjGenerico<T> aplicaDeMorgan(ConjGenerico<T> conj1,
												 ConjGenerico<T> conj2, ConjGenerico<T> universo) throws Exception {
		ConjGenerico<T> conj1Comp = conj1.complementar(universo);
		ConjGenerico<T> conj2Comp = conj2.complementar(universo);

		Elo q, p1 = conj1Comp.prim, p2 = conj2Comp.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<>();

		while ( (p1 != null) && (p2 != null) )
		{
			if (p1.dado.compareTo(p2.dado) < 0)
			{
				p1 = p1.prox;
			}
			else if(p2.dado.compareTo(p1.dado) < 0)
			{
				p2 = p2.prox;
			}
			else
			{
				q = new Elo(p1.dado);

				p1 = p1.prox;
				p2 = p2.prox;

				if (ult == null)
					inter.prim = q;
				else
					ult.prox = q;

				ult = q;
			}
		}
		return inter;
	}


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