/* 
 *	Progetto autunnale 2015/16 Programmazione 2
 *	Autore: Cau Fabrizio (Matricola: 508700)
 *	Programma che testa i metodi implementati in ElasticSetImp su un ElasticSet di tipo String
 */
 
import java.util.ArrayList;
import java.util.List;


public class TestTs2 {

	public static void main(String[] args) {
		

		ElasticSetImp<String> mySet = new ElasticSetImp<String>();
		
		int i=0; 

		mySet.add("aaab");

		// TEST Metodo gbl(e)
		System.out.println("gbl(a): "+mySet.gbl("a"));
		System.out.println("gbl(bbb): "+mySet.gbl("bbb"));
		
		// TEST Metodo lub(e)
		System.out.println("lub(a): "+mySet.lub("a"));
		System.out.println("lub(bbb): "+mySet.lub("bbb"));
		
		mySet.remove("aaab");

		for(i=97;i<=122;i++)
			mySet.add(Character.toString((char)i));
	
		
		// TEST Metodo view(f,t)
		List<String> lis = new ArrayList<String>();
		lis = mySet.view("f","k");
		System.out.print("view(f,k) = { ");
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
		System.out.println("exist(a,f): "+mySet.exist("a","f"));

		// TEST Metodo exist(f,t)
		System.out.println("exist(a,b): "+mySet.exist("a","b"));
	}

}
