public class Pilha
{
	private int n;
	private char vetor[];
	private int topo;
	private int pares;
	
	public Pilha()
	{
		n = 10;
		vetor = new char[n];
		topo = -1;
		pares = 0;
	}
	
	public Pilha(int tamanho)
	{
		n = tamanho;
		vetor = new char[tamanho];
		topo = -1;
		pares = 0;
	}
	
	public boolean vazia()
	{
		return topo == -1 ? true : false;
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public char pop()
	{
		char c = '\0';

		if (!this.vazia())
		{
			c = vetor[topo];

			if ((int)c %2 == 0){
				pares--;
			}
			
			//Decrementando o topo, o elemento é "removido"
			topo--;
		}
		else
		{
			//Impressão para fins didáticos
			System.out.println("Pilha vazia: pop não funcionou.");
		}
		
		return c;
	}
	
	public boolean push(char elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			if ((int)elemento %2 == 0){
				pares++;
			}
			return true;
		}
		else
		{
			//Impressão para fins didáticos
			System.out.println("Pilha cheia: push não funcionou.\n");
			return false;
		}
	}
	
	public char retornaTopo()
	{
		char elemento = '\0';

		if(!this.vazia())
		{
			elemento = vetor[topo];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}

	public int contaPares(){
		return pares;
	}
}