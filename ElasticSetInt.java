/* 
 *	Progetto autunnale 2015/16 Programmazione 2
 *	Autore: Cau Fabrizio (Matricola: 508700)
 *	Interfaccia ElasticSet + Specifica dei metodi
 */

import java.util.List;


public interface ElasticSetInt<E> {
	
	//OVERVIEW: ElesticSet è una collezione di oggetti omogenei generici in cui 
	// non sono presenti elementi duplicati.
	//TYPICAL ELEMENT: [e1,e2,e3,...,eN] 
	
	public boolean add(E e);	
	//REQUIRES: e non null
	//MODIFIES: ElSet
	//EFFECTS: Aggiunge l'elemento e al set se questo non era già presente, false altrimenti.
	// Lancia NullPointerException (unchecked) se e = null (da specifica add di TreeSet)
	
	public boolean remove(E e);
	//REQUIRES: e non null
	//MODIFIES: ElSet
	//EFFECTS: Rimuove l'elemento e dal set e restituisce true se questo era presente, false altrimenti. 
	// Lancia NullPointerException (unchecked) se e = null (da specifica remove di TreeSet)
	
	public boolean contains(E e);
	//REQUIRES: e non null
	//EFFECTS: Restituisce true se l'elemento e è contenuto nel set, false altrimenti.
	// Lancia NullPointerException (unchecked) se e = null (da specifica contains di TreeSet)
	
	public boolean isEmpty();
	//EFFECTS: Restituisce true se il set è vuoto, false altrimenti.
	
	
	E gbl(E e);
	//REQUIRES: e non null
	//EFFECTS: Restituisce il più grande elemento della collezione che è minore 
	// o uguale all'elemento e (greatest lower bound), e null se tale elemento 
	// non esiste. Lancia NullPointerException (unchecked) se e è null.
	
	E lub(E e);
	//REQUIRES: e non null
	//EFFECTS: Restituisce il più piccolo elemento della collezione che è 
	// maggiore o uguale all'elemento e (least upper bound), e null se tale elemento 
	// non esiste. Lancia NullPointerException (unchecked) se e è null. 
	
	List<E> view(E f, E t);
	//REQUIRES: f e t non null, f < t
	//EFFECTS: Restituisce una vista degli elementi della collezione che sono
	// maggiori o uguali a f e minori o uguali a t. Lancia NullPointerException (unchecked) 
	// se f o t sono null e IllegalArgumentException (unchecked) se f > t 
	
	E max();
	//EFFECTS: Restituisce l'elemento più grande della collezione, 
	// e null se la collezione è vuota
	
	E min();
	//EFFECTS: Restituisce l'elemento più piccolo della collezione, 
	// e null se la collezione è vuota
	
	boolean rmFirst();
	//REQUIRES: collezione non vuota
	//MODIFIES: ElSet
	//EFFECTS: Rimuove l'elemento più piccolo della collezione, e lancia 
	// EmptyCollectionException (unchecked) se la collezione è vuota.
	
	boolean rmLast();
	//REQUIRES: collezione non vuota
	//MODIFIES: ElSet
	//EFFECTS: Rimuove l'elemento più grande della collezione, e lancia 
	// EmptyCollectionException (unchecked) se la collezione è vuota.
	
	E exist(E f, E t);
	//REQUIRES: f e t non null, t < t
	//EFFECTS: Restituisce un elemento più grande di f e più piccolo 
	// di t della collezione - se sono più di uno restituisce la prima 
	// occorrenza - e null se tale elemento non esiste o se il set è vuoto 
	// Lancia NullPointerException se f o t sono null	
	// Lancia IllegalArgumentException (unchecked) se f>t 

}

		