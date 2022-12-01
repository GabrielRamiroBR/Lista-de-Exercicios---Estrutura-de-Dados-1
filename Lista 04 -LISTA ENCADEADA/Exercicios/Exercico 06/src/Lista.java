public abstract class Lista
{

	protected Elo prim;
	
	protected class Elo
	{
		protected String nome;


		
		public Elo(String s)
		{
			nome = s;

		}
	}
	
	public Lista()
	{
		prim = null;
	}

	public abstract boolean isArquivo();


}