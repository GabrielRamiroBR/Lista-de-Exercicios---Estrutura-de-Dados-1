public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;/* Referência para primeiro elemento. */
	private Elo ult;

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
		ult = null;
	}
	/* Exercicio 01
	Complexidade O(1)
	 */
	public T menor(){
		if (prim == null)
			throw new NullPointerException ("Lista Vazia");
		return prim.dado;
	}
	public T maior(){
		if (ult == null)
			throw new NullPointerException ("Lista Vazia");
		return ult.dado;
	}


	/* Inserção de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento já estava lá. */
	public boolean insere(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) == 00) return false;
			if (p.dado.compareTo(valor) > 0) break;

			ant = p;
		}

		Elo q = new Elo(valor);

		if (p == prim) {
			prim = q;
		}
		else
			ant.prox = q;

		if (prim.prox == null)
			ult = prim;
		if (valor.compareTo(ult.dado) > 0)
			ult = q;

		q.prox = p;

		return true;
	}

	/* Remoção de elemento do conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento não estava lá. */
	public boolean remove(T valor)
	{
		Elo p , ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) == 0) break;
			if (p.dado.compareTo(valor) > 0) return false;

			ant = p;
		}

		if (p == null)
			return false;

		if (p == prim)
			prim = prim.prox;
		else
			ant.prox = p.prox;

		if (p == ult)
			ult = ant;

		p = null;


		return true;
	}

}