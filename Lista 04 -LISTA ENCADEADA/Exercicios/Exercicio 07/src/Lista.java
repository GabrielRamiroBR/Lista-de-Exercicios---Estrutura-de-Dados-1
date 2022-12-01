public class Lista {

	protected Elo prim;

	protected class Elo {
		protected Inimigo dado;
		protected Elo prox;

		public Elo() {
			prox = null;
		}

		public Elo(Inimigo elem) {
			dado = elem;
			prox = null;
		}

		public Elo(Inimigo elem, Elo proxElem) {
			dado = elem;
			prox = proxElem;
		}
	}

	public Lista() {
		prim = null;
	}

	/* Testa se a lista está vazia. */
	public boolean vazia() {
		return prim == null;
	}

	/* Complexidade O(1)*/
	public void insere(Inimigo inimigo) {
		Elo p = new Elo(inimigo);
		p.prox = prim;
		prim = p;
	}

	/* Complexidade O(n)*/
	public Inimigo localizar(Inimigo inimigo) {
		Elo p;
		for (p = prim; p.dado != inimigo && p != null; p = p.prox) ;
		return p.dado;
	}

	/* Complexidade 2n -> O(n)*/
	public int efetuarDano(Inimigo inimigo, double dano) {
		if (localizar(inimigo) != null) {
			if (inimigo.getVida() <= dano) {

				Elo p, ant = null;
				for (p = prim; p.dado != inimigo; p = p.prox)
					ant = p;

				if (p == prim)
					prim = prim.prox;
				else
					ant.prox = p.prox;

				p = null;
				return 0;
			} else {
				inimigo.setVida((int) (inimigo.getVida() - dano));
				return (int) (inimigo.getVida() - dano);
			}
		}
		return Integer.MIN_VALUE;
	}

}