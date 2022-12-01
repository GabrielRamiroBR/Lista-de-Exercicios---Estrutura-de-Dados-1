public class Lista<T> {
	/* Referência para primeiro elemento */
	protected Elo prim;

	protected class Elo<T> {
		protected T dado;
		protected Elo prox;

		public Elo() {
			prox = null;
		}

		public Elo(T elem) {
			dado = elem;
			prox = null;
		}

		public Elo(T elem, Elo proxElem) {
			dado = elem;
			prox = proxElem;
		}
	}

	public Lista() {
		prim = null;
	}
}
	
