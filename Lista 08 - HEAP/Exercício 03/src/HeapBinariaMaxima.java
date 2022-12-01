public class HeapBinariaMaxima
{
	protected int n;               /* Numero de elementos no heap. */
	protected int tam;             /* Tamanho máximo do heap. */
	protected int[] vetor;          /* Vetor com elementos. */

	/* Constrói heap vazio. */
	public HeapBinariaMaxima(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new int[tamanho+1];
	}

	/* Constrói heap a partir de vetor v. */
	public HeapBinariaMaxima(int tamanho, int[] v)
	{
		tam = tamanho;
		vetor = new int[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	// Exercicio 03 -  Complexidade do metodo heapfy() -> log(n) = altura da árvore no pior caso (raiz descer até a folha)
	// Complexidade do metodo HeapBinariaMinima n/2 * log(n) - > logo a complexidade final é O(nlog(n))
	public HeapBinariaMaxima(HeapBinariaMinima heapMinima){
		// copia o vetor da heap de parametro para um vetor auxiliar
		int n = heapMinima.vetor.length - 1;
		int[] vetorAux = new int[n + 1];
		for (int i = 0 ; i < n; i++){
			vetorAux[i + 1] = heapMinima.vetor[i +1];
		}

		for(int i = n/2; i > 0; i--){
			maxHeapfy(vetorAux, n, i);
		}

		this.n = n;
		this.tam = n;
		this.vetor = new int[n+1];
		for (int i = 0; i < n; i++)
			this.vetor[i+1] = vetorAux[i+1];
	}
	private void maxHeapfy(int[] A, int n, int i ) {
		int esq = i * 2, dir = i * 2 + 1, maior;

		if (esq <= n && A[esq] > A[i])
			maior = esq;
		else
			maior = i;
		if (dir <= n && A[dir] > A[maior])
			maior = dir;
		if (maior != i) {
			int aux = A[maior];
			A[maior] = A[i];
			A[i] = aux;
			maxHeapfy(A, n, maior);
		}
	}

	/* Testa se a fila de prioridade está logicamente vazia.
	   Retorna true se vazia, false, caso contrário. */
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

	/* Método auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitrário dos itens. */
	private void constroiHeap()
	{
		/* As posições n até a posição (n / 2) + 1 já constituem uma heap,
		 * pois são folhas. */
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* Método auxiliar para restaurar a propriedade de heap que
	 * não está sendo respeitada pelo nó i. */
	private void refaz(int i)
	{
		int x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o maior filho é o da esquerda. */
			maiorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se é maior que o filho esquerdo. */
				if(vetor[ filhoDir ] > vetor[ filhoEsq ])
					maiorFilho = filhoDir;
			}

			if(vetor[ maiorFilho ] > x)
				vetor [ i ] = vetor[ maiorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posição "i" desceu para o nível de baixo, a próxima
			 * iteração vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posição "maiorFilho") com um de seus novos filhos. */
			i = maiorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * São permitidas duplicatas. */
	public void insere(int x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento é inicialmente inserido na primeira posição disponível
		 * na árvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do nó raiz (de índice 1). */
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

	/* Implementa o algoritmo de ordenação Heapsort. */
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