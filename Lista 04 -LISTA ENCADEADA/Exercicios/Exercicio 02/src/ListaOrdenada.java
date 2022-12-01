public class ListaOrdenada extends Lista
{

/* Questão 02 da lista 04*/
	public ListaOrdenada intercala ( ListaOrdenada l2) {
		ListaOrdenada l3 = new ListaOrdenada();

		Elo p1, p2, ult, q;
		ult = null;

		for (p1 = prim, p2 = l2.prim; p1 != null || p2 != null; ) {
			if (p1 != null && p2 == null) {
				q = new Elo(p1.dado);
				p1 = p1.prox;
			} else {
				if (p1.dado > p2.dado) {
					q = new Elo(p2.dado);
					p2 = p2.prox;
				} else if (p1.dado < p2.dado) {
					q = new Elo(p1.dado);
					p1 = p1.prox;
				} else {
					q = new Elo(p1.dado);
					p1 = p1.prox;
					p2 = p2.prox;
				}

			}
			if (ult == null)
				l3.prim = q;
			else
				ult.prox = q;

			ult = q;
		}
		return l3;
	}
	public void insere(int novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null; /* referência para anterior */
		
		for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
			ant = p;
		
		/* Se p é null ou p.dado != elem, então não encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do início. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a última referência para o elo a ser removido. Dessa forma,
		 * o Garbage Collector irá liberar essa memória. */
		p = null;
		
		return true;
	}
}