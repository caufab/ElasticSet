/* 
 *	Progetto autunnale 2015/16 Programmazione 2
 *	Autore: Cau Fabrizio (Matricola: 508700)
 *	Programma che testa i metodi implementati in ElasticSetImp su un ElasticSet di tipo Integer
 */
 
 import java.util.ArrayList;
import java.util.List;


public class TestTs1 {

	public static void main(String[] args) {
		

		ElasticSetImp<Integer> mySet = new ElasticSetImp<Integer>();
		
		int i=0; 

		mySet.add(1);
		
		// TEST Metodo gbl(e)
		System.out.println("gbl(0): "+mySet.gbl(0));
		System.out.println("gbl(2): "+mySet.gbl(2));
		
		// TEST Metodo lub(e)
		System.out.println("lub(0): "+mySet.lub(0));
		System.out.println("lub(2): "+mySet.lub(2));
		
		for(i=2;i<=20;i++)
			mySet.add(i);
		
		// TEST Metodo view(f,t)
		List<Integer> lis = new ArrayList<Integer>();
		lis = mySet.view(4,10);
		System.out.print("view(4,10) = { ");
		for(i=0;i<lis.size();i++)
			System.out.print(lis.get(i)+",");
		System.out.println("}");
		
		// TEST Metodo max()
		System.out.println("max(): "+mySet.max());
		// TEST Metodo min()
		System.out.println("min(): "+mySet.min());
		
		// TEST Metodo rmFirst()
		System.out.println("rmFirst(): "+mySet.rmFirst());
		// TEST Metodo rmLast()
		System.out.println("rmLast(): "+mySet.rmLast());
		
		// TEST Metodo max()
		System.out.println("max(): "+mySet.max());
		// TEST Metodo min()
		System.out.println("min(): "+mySet.min());		
		
		
		// TEST Metodo exist(f,t)
		System.out.println("exist(0,5): "+mySet.exist(0,5));

		// TEST Metodo exist(f,t)
		System.out.println("exist(0,2): "+mySet.exist(0,2));
	}

}
