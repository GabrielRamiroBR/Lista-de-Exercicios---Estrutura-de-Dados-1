public class ListaOrdenadaGenerica<T> extends Lista<T>
{

	/* Complexidade do m�todo insere() : n.m (quadr�tica) onde n � o tamanho da lista e
	 m � o tamanho da String dentro do Elo.
	 */
	public void insere(T novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado.toString().compareTo(novo.toString()) < 0)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Complexidade do m�todo insere() : n.m (quadr�tica) onde n � o tamanho da lista e
	 m � o tamanho da String dentro do Elo.
	 */
	public boolean remove(T elem)
	{
		Elo p;
		Elo ant = null; /* refer�ncia para anterior */
		
		for(p = prim; ((p != null) && (p.dado.toString().compareTo(elem.toString()) < 0)); p = p.prox)
			ant = p;
		
		/* Se p � null ou p.dado != elem, ent�o n�o encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
		 * o Garbage Collector ir� liberar essa mem�ria. */
		p = null;
		
		return true;
	}
}