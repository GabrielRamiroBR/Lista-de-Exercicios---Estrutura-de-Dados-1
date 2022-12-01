public class HeapBinariaMaxima <T extends Comparable<T>>
{
	protected int n;               /* Numero de elementos no heap. */
	protected int tam;             /* Tamanho m�ximo do heap. */
	protected int[] vetor;          /* Vetor com elementos. */

	/* Constr�i heap vazio. */
	public HeapBinariaMaxima(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new int[tamanho+1];
	}

	/* Constr�i heap a partir de vetor v. */
	public HeapBinariaMaxima(int tamanho, int[] v)
	{
		tam = tamanho;
		vetor = new int[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();


	}
	/* Exercico 3  O(nlog(n))*/
	public void transformaHeapMaxima(Arvbin<T> arvore){
		int n = arvore.contaNos();
		T[] vetor = (T[]) new Object[n + 1];

		criaVetor(arvore, vetor);

		for(int i = n/2; i > 0; i--){
			maxHeapfy(vetor, n, i);
		}

	}

	public T[] criaVetor(Arvbin<T> arvore, T[] vetor){
		int i = 1;


		if (arvore.val == null) {
			System.out.print("?rvore vazia");
		}
		else{
			vetor[i] = arvore.val;

			if (arvore.esq != null){
				i++;
				criaVetor(arvore.esq, vetor);
			}
			if (arvore.dir != null){
				i++;
				criaVetor(arvore.dir, vetor);
			}
		}
		return vetor;
	}
	private void maxHeapfy(T[] A, int n, int i ) {
		int esq = i * 2, dir = i * 2 + 1, maior;

		if (esq <= n && A[esq].compareTo(A[i]) > 0)
			maior = esq;
		else
			maior = i;
		if (dir <= n && A[dir].compareTo(A[maior]) > 0)
			maior = dir;
		if (maior != i) {
			T aux = A[maior];
			A[maior] = A[i];
			A[i] = aux;
			maxHeapfy(A, n, maior);
		}
	}


	/* Testa se a fila de prioridade est� logicamente vazia.
	   Retorna true se vazia, false, caso contr�rio. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}

	/* Busca o maior item na fila de prioridades.
	   Retorna o maior item em itemMin e true, ou falso se a heap estiver vazia. */
	public int max()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		return vetor[1];
	}

	/* Remove o maior item da lista de prioridades e coloca ele em itemMax. */
	public int removeMax()
	{
		int itemMax;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		itemMax = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMax;
	}

	/* M�todo auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitr�rio dos itens. */
	private void constroiHeap()
	{
		/* As posi��es n at� a posi��o (n / 2) + 1 j� constituem uma heap,
		 * pois s�o folhas. */
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* M�todo auxiliar para restaurar a propriedade de heap que
	 * n�o est� sendo respeitada pelo n� i. */
	private void refaz(int i)
	{
		int x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o maior filho � o da esquerda. */
			maiorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se � maior que o filho esquerdo. */
				if(vetor[ filhoDir ] > vetor[ filhoEsq ])
					maiorFilho = filhoDir;
			}

			if(vetor[ maiorFilho ] > x)
				vetor [ i ] = vetor[ maiorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posi��o "i" desceu para o n�vel de baixo, a pr�xima
			 * itera��o vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posi��o "maiorFilho") com um de seus novos filhos. */
			i = maiorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * S�o permitidas duplicatas. */
	public void insere(int x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento � inicialmente inserido na primeira posi��o dispon�vel
		 * na �rvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do n� raiz (de �ndice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x > vetor[pos/2])
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	public int[] getVetor() {
		return vetor;
	}

	public int getTam() {
		return tam;
	}

	/* Implementa o algoritmo de ordena��o Heapsort. */
	public void heapsort()
	{
		int x;           
		int resta = n;
		int raiz = 1;
		constroiHeap();
		
		while (resta > 1)
		{
			x = vetor[raiz];
			vetor[raiz] = vetor[resta];
			vetor[resta] = x;
			resta--;
			refaz(raiz);
		}
	}
}