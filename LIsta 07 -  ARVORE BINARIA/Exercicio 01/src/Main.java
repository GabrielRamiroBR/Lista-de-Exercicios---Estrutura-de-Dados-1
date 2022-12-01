import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
	public static void main(String[] args)
	{
		Arvbin <String> a1 = new Arvbin<>("C");
		Arvbin <String> a2 = new Arvbin<>("E");
		Arvbin <String> a3 = new Arvbin<>("F"); // folhas//

		Arvbin <String> a4 = new Arvbin<>("B", a1, null);
		Arvbin <String> a5 = new Arvbin<>("D", a2, a3);
		Arvbin <String> a6 = new Arvbin<>("A", a4, a5); // raiz

		a6.imprimePreOrdem();
		System.out.println();
		a6.imprimeEmOrdem();
		System.out.println();
		a6.imprimePosOrdem();

	}
}
