public class Lista
{
	/* Referência para primeiro elemento */
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

	/* Questão 04 - Lista 04
	* Complexidade O(n)*/
	public String frase(){
		String s = "";
		Elo p;

		for (p = prim; p != null; p = p.prox){
			if (p.dado.length() == 1 && p.dado.toLowerCase().charAt(0) < 97 ) //verifica seo elo é pontuaçao
				s = s + p.dado;
			else
				s = s + " " + p.dado;
		}
		return s;
	}
	
	/* Testa se a lista está vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no início da lista. */
	public void insere(String novo)
	{
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
	}
	
	/* Verifica se um determinado elemento está na lista. */
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
	
	/* Implementação recursiva do método de busca. */
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

	/* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
	public boolean remove(String elem)
	{
		Elo p;
		Elo ant = null; /* Referência para anterior. */
		
		for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
			ant = p;
		
		/* Se p é null, então não encontrou elemento. */
		if (p == null)
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
	
	/* Implementação recursiva da função de impressão. */
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
	

	/* Resolução da questão 3 da lista auxiliar de Lista Encadeada. */
	public Lista separa(String n)
	{
		Lista l2 = new Lista();
		
		Elo p;
		
		/* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
		for(p = prim; (p != null) && (p.dado != n); p = p.prox);
		
		/* Caso tenha chegado ao fim da lista sem encontrar o elemento. */
		if(p == null)
			return null;
		
		/* O "prim" da nova lista é o próximo do elo apontado por p. */
		l2.prim = p.prox;
		
		/* Faz o elo apontado por p ser o último elo da lista original. */
		p.prox = null;
		
		/* Retorna a nova lista construída. */
		return l2;
	}
	
	/* Resolução da questão 4 da lista auxiliar de Lista Encadeada. */
	public static Lista concatena(Lista l1, Lista l2)
	{
		Elo p;
		
		/* Verifica se a lista l1 é vazia. */
		if(l1.prim == null)
		{
			l1.prim = l2.prim;
		}
		else
		{
			/* Primeiramente, precisamos obter o último elo da lista l1. */
			for(p = l1.prim; p.prox != null; p = p.prox);

			/* Faz o "prox" do último elemento da lista l1, apontado por "p",
			 * apontar para o "prim" da lista l2. */
			p.prox = l2.prim;
		}
		
		/* Nesse ponto, os elementos de l2 já estão encadeados ao final de l1,
		 * como desejado. Assim, vamos deixar a lista l2 vazia. */
		l2.prim = null;
		
		return l1;
	}
	

}