public class Lista
{
	/* Refer�ncia para primeiro elemento */
	protected Elo prim;
	
	protected class Elo
	{
		protected String dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(String elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(String elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public Lista()
	{
		prim = null;
	}

	/* Quest�o 04 - Lista 04
	* Complexidade O(n)*/
	public String frase(){
		String s = "";
		Elo p;

		for (p = prim; p != null; p = p.prox){
			if (p.dado.length() == 1 && p.dado.toLowerCase().charAt(0) < 97 ) //verifica seo elo � pontua�ao
				s = s + p.dado;
			else
				s = s + " " + p.dado;
		}
		return s;
	}
	
	/* Testa se a lista est� vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no in�cio da lista. */
	public void insere(String novo)
	{
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
	}
	
	/* Verifica se um determinado elemento est� na lista. */
	public boolean busca(String elem)
	{
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			if(p.dado == elem)
				return true;
		}
		
		return false;
	}
	
	/* Implementa��o recursiva do m�todo de busca. */
	public boolean buscaRecursiva(String elem)
	{
		if(this.vazia())
			return false;
		
		return buscaRecursiva(elem, prim);
	}
	
	private boolean buscaRecursiva(String elem, Elo p)
	{
		if(p == null)
			return false;
		
		if(p.dado == elem)
			return true;
		
		return buscaRecursiva(elem, p.prox);
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(String elem)
	{
		Elo p;
		Elo ant = null; /* Refer�ncia para anterior. */
		
		for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;
		
		/* Se p � null, ent�o n�o encontrou elemento. */
		if (p == null)
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
	
	/* Imprime todos os elementos da lista. */

	/* Resposta da Questao 1 - Complexidade O(n)*/
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	/* Implementa��o recursiva da fun��o de impress�o. */
	public void imprimeRecursivo()
	{
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p)
	{
		if(p == null)
			return;
		
		System.out.print(p.dado + " ");
		
		imprimeRecursivo(p.prox);
	}
	
	/* Calcula e retorna o tamanho da lista. */
	public int tamanho()
	{
		int tam = 0;
		Elo p = prim;
		
		while(p != null)
		{
			tam++;
			p = p.prox;
		}
		
		return tam;
	}
	
	/* Calcula e retorna o tamanho da lista de maneira recursiva. */
	public int tamanhoRecursivo()
	{
		if(this.vazia())
			return 0;
		
		return tamanhoRecursivo(prim);
	}
	
	private int tamanhoRecursivo(Elo p)
	{
		if(p == null)
			return 0;
		
		return 1 + tamanhoRecursivo(p.prox);
	}
	

	/* Resolu��o da quest�o 3 da lista auxiliar de Lista Encadeada. */
	public Lista separa(String n)
	{
		Lista l2 = new Lista();
		
		Elo p;
		
		/* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
		for(p = prim; (p != null) && (p.dado != n); p = p.prox);
		
		/* Caso tenha chegado ao fim da lista sem encontrar o elemento. */
		if(p == null)
			return null;
		
		/* O "prim" da nova lista � o pr�ximo do elo apontado por p. */
		l2.prim = p.prox;
		
		/* Faz o elo apontado por p ser o �ltimo elo da lista original. */
		p.prox = null;
		
		/* Retorna a nova lista constru�da. */
		return l2;
	}
	
	/* Resolu��o da quest�o 4 da lista auxiliar de Lista Encadeada. */
	public static Lista concatena(Lista l1, Lista l2)
	{
		Elo p;
		
		/* Verifica se a lista l1 � vazia. */
		if(l1.prim == null)
		{
			l1.prim = l2.prim;
		}
		else
		{
			/* Primeiramente, precisamos obter o �ltimo elo da lista l1. */
			for(p = l1.prim; p.prox != null; p = p.prox);

			/* Faz o "prox" do �ltimo elemento da lista l1, apontado por "p",
			 * apontar para o "prim" da lista l2. */
			p.prox = l2.prim;
		}
		
		/* Nesse ponto, os elementos de l2 j� est�o encadeados ao final de l1,
		 * como desejado. Assim, vamos deixar a lista l2 vazia. */
		l2.prim = null;
		
		return l1;
	}
	

}