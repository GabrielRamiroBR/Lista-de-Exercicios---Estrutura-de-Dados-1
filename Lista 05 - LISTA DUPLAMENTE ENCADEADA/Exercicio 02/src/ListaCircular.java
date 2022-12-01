import javax.swing.*;

public class ListaCircular extends Lista
{
/* Exercicio 02 Lista 05
* Complexidade O(n²)*/
	public ListaCircular merge(ListaCircular lista2){
		ListaCircular l3 = new ListaCircular();

		if (prim != null && lista2.prim != null){
			Elo p = prim, q = lista2.prim, k, a;

			k = new Elo(p.dado);
			l3.prim = k;
			k.prox = new Elo (q.dado);
			k.prox.prox = l3.prim;

			p = p.prox;
			q = q.prox;

			while (p != prim || q != lista2.prim){
				if (p != prim) {
					k = new Elo(p.dado);
					a = l3.prim;

					while (a.prox != l3.prim) {
						a = a.prox;
					}

					a.prox = k;
					k.prox = l3.prim;

					p = p.prox;
				}


				if ( q != lista2.prim) {
					k = new Elo(q.dado);
					a = l3.prim;

					while (a.prox != l3.prim) {
						a = a.prox;
					}

					a.prox = k;
					k.prox = l3.prim;

					q = q.prox;
				}
			}
		}
		else {
			if (prim == null && lista2.prim != null) {
				Elo q = lista2.prim, k, a;

				k = new Elo(q.dado);
				l3.prim = k;
				k.prox = k;

				q = q.prox;

				while (q != lista2.prim) {

					k = new Elo(q.dado);
					a = l3.prim;

					while (a.prox != l3.prim) {
						a = a.prox;
					}

					a.prox = k;
					k.prox = l3.prim;

					q = q.prox;
				}
			}
			else if (prim != null && lista2.prim == null) {
				Elo q = prim, k, a;

				k = new Elo(q.dado);
				l3.prim = k;
				k.prox = k;

				q = q.prox;

				while (q != prim) {

					k = new Elo(q.dado);
					a = l3.prim;

					while (a.prox != l3.prim) {
						a = a.prox;
					}

					a.prox = k;
					k.prox = l3.prim;

					q = q.prox;
				}
			}
			else
				return null;
		}
		return l3;
	}
	/* Imprime todos os elementos da lista */
	public void imprime()
	{
		Elo p;
		System.out.println("Elementos da lista");
		
		p = prim;
		
		if (p != null)
		{
			do
			{
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}
		
		System.out.println();
	}
	
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
		System.out.print(p.dado + " ");
		
		if(p.prox == prim)
			return;
		
		imprimeRecursivo(p.prox);
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null)
		{
			/* Percorre até alcancar o início. */
			while (p.prox != prim)
			{
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		}
		else
		{
			prim = q;
			prim.prox = q;     
		}
	}
	
	public boolean remove(int elem)
	{
		Elo p = null;
		Elo ant = null;

		if (prim == null) return false;

		for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
			ant = p;

		/* Achou */
		if ( p.dado == elem )
		{
			/* É o primeiro */     
			if ( p == prim )
			{
				/* É o único */
				if ( prim == prim.prox )
				{
					prim = null;  
				}
				else
				{
					/* Guarda o anterior ao primeiro */
					for( ant = prim; ( ant.prox != prim ); ant = ant.prox);
					
					ant.prox = prim.prox; 
					prim = prim.prox; 
				}     
			}   
			else
			{
				/* No meio */
				ant.prox = p.prox;     
			} 

			/* Remove a última referência para o elo a ser removido. Dessa forma,
			 * o Garbage Collector irá liberar essa memória. */
			p = null;

			return true;    
		}
		else  
			return false;
	}
	
	/* Resolução da questão 3 da lista auxiliar de Lista Encadeada. */
	public Lista separa(int n)
	{
		Lista l2 = new Lista();
		
		Elo p = prim;
		
		/* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
		do
		{
			/* Encontrou o elemento desejado. */
			if(p.dado == n)
				break;
			
			p = p.prox;
			
		} while (p != prim);
				
		/* Caso tenha percorrido a lista sem encontrar o elemento. */
		if(p.dado != n)
			return null;
		
		/* O "prim" da nova lista é o próximo do elo apontado por p. */
		l2.prim = p.prox;
		
		/* O próximo do elo apontado por p tem que apontar para o prim da
		 * lista original. */
		p.prox = prim;
		
		Elo q;
		
		/* Anda até o último elemento da lista 2. */
		for(q = l2.prim; q.prox != prim; q = q.prox);
		
		/* O próximo do último elemento da lista 2 aponta para o primeiro. */
		q.prox = l2.prim;

		/* Retorna a nova lista construída. */
		return l2;
	}
}