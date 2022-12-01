package ramiro.EDD1.unirio;


public class PilhaGenerica<T>
{
	private int n;
	private T[] vetor;
	private int topo;
	
	public PilhaGenerica(int tamanho)
	{		
		n = tamanho;
		vetor = (T[]) new Object[n];
		topo = -1;
	}

	public boolean vazia()
	{
		return topo == -1 ? true : false; 
	}
	
	public boolean cheia()
	{
		return topo == n - 1 ? true : false;
	}
	
	public T pop()
	{
		T elemento = null;
		
		if (!this.vazia())
		{
			elemento = vetor[topo--];
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha vazia: pop nao funcionou.");
		}
		return elemento;
	}
	
	public boolean push(T elemento)
	{
		if (!this.cheia())
		{
			vetor[++topo] = elemento;
			return true;
		}
		else
		{
			//Impress�o para fins did�ticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}
	
//	public boolean retornaTopo(T elemento)
//	{
//	     if(!this.vazia()){
//	        elemento = vetor.get(topo);
//	        return true;
//	     }
//	     else
//	    	 return false;
//	}

		public T retornaTopo()
	{
	     if(!this.vazia()){
	        T elemento = vetor[topo];
	        return elemento;
	     }
	     else
	    	 return null;
	}
}