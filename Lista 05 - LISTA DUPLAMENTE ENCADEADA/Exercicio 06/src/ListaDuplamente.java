public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	
	protected class Elo
	{
		protected Chamada dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(Chamada elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(Chamada elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
	}
	
	/* Testa se a lista está vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Questão 06 Lista 05
	* Complexidade O (n)
	* Insere chamadas nas listas dividindo em duas partes:
	* a primeira parte da lista sao as chamadas de prioridade a segunda são chamadas sem prioridade
	* chamadas novas são inseridas no inicio das respectivas partes*/
	public void insere(Chamada novo)
	{
		Elo p, q;
		
		p = new Elo(novo);

		if (novo.isLonge()){
			p.prox = prim;
			p.ant = null;

			if (prim != null)
				prim.ant = p;
			prim = p;
		}
		else{
			for (q = prim; q != null && q.dado.isLonge(); q = q.prox);
			if (q == null){
				p.prox = q;
				p.ant = null;
				prim = p;
			}
			else{
				p.ant = q.ant;
				p.prox = q;
				if (q != prim)
					q.ant.prox = p;
				q.ant = p;
				if (!prim.dado.isLonge()){
					prim = p;
				}
			}
		}
	}


/* Questao 06 da lista 05
Complexidade O(n)
 */
	public boolean remove(){
		if (prim == null)
			return false;

		Elo p = prim;
		/* Remove a chamada da fila de prioridade mais antigo*/
		if (p.dado.isLonge()){
			while (p.prox.dado.isLonge())
				p = p.prox;
			if (p != prim){
				p.ant.prox = p.prox;
				p.prox.ant = p.ant;
			}
			else {
				prim = p.prox;
				prim.ant = null;
			}
			p = null;
		}
		else{
			/*remove a chamada sem pioridade mais antiga*/
			while (p.prox != null)
				p = p.prox;
			if (p != prim){
				p.ant.prox = null;
			}
			else{
				prim = null;
			}
			p = null;
		}
		return true;
	}
	

	
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado.getNumero() + " ");
		}
		
		System.out.println();
	}

}