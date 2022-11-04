/* 
 *	Progetto autunnale 2015/16 Programmazione 2
 *	Autore: Cau Fabrizio (Matricola: 508700)
 *	Implementazione ElasticSet + Funzione di Astrazione e Invariante di Rappresentazione + note di progetto
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class ElasticSetImp<E extends Comparable<E>> {
	/* NOTE tipo generico esteso a comparable 
	 * Viene esteso il tipo generico E alla classe Comparable per poter confrontare 
	 * gli elmenti del set tra di loro e permettere quindi l'ordinamento standard dei 
	 * metodi del TreeSet. Nel caso in cui si tenta l'inserimento di elementi non 
	 * confrontabili il medoto compareTo non può effettuare il confronto e lancia 
	 * l'eccezione ClassCastException (unchecked) come specificato dalla classe Comparable
	 */
	
	/*	FUN ASTRAZ e REP INV 
	 * 
	 * AF(e) = [ e[0],e[1],...,e[n] ]
	 * elenco ordinato di elementi e omogenei di tipo generico E confrontabili 
	 * non ripetuti 
	 * 
	 * REP INV:
	 *   
	 * I(c) = se c.size()>1 
	 * per ogni i,j. 0 <= i < j <= c.size() ==>  c[i] < c[j] && 
	 * per ogni i. 0<= i <= c.size() ==> C extends Comparable
	 *  dove C è il tipo generico di c
	 * 
	 */
	
	private TreeSet<E> ElSet;
	/* NOTE TreeSet 
	 * La scelta di utilizzare una struttura dati della classe TreeSet deriva
	 * dai metodi offerti da essa, in quanto mantenendo un set ordinato fornisce alcuni metodi 
	 * che implementano gran parte delle funzioni richieste dalla specifica del ElasticSet
	 */
	
	public ElasticSetImp() {
		ElSet = new TreeSet<E>();
	}
	
	/* NOTE (add,remove,contains,isEmpty) 
	 * Implementando una struttura dati propria è necessario reimplementare anche i metodi 
	 * standard del Set (i seguenti: add,remove,contains,isEmpty) e si è scelto di sovrascriverli 
	 */	
	public boolean add(E e) {	 
		return ElSet.add(e);
	}
	
	public boolean remove(E e){
		return ElSet.remove(e);		
	}
	
	public boolean contains(E e){
		return ElSet.contains(e);
		
	}
	
	public boolean isEmpty(){ 
		return ElSet.isEmpty();
	}	


	
	public E gbl(E e) throws NullPointerException {
		if(e==null)
			throw new NullPointerException();
		return ElSet.floor(e);
	}

	
	public E lub(E e) throws NullPointerException {
		if(e==null)
			throw new NullPointerException();
		return ElSet.ceiling(e);		
	}

	
	public List<E> view(E f, E t) throws NullPointerException, IllegalArgumentException {
		
		if(f==null || t == null)
			throw new NullPointerException();
		else {
			if(f.compareTo(t) > 0)
				throw new IllegalArgumentException();	
			else {
				if(ElSet.isEmpty())		
					return new ArrayList<E>();
				else
					return new ArrayList<E>(ElSet.subSet(ElSet.ceiling(f), true, ElSet.floor(t), true));
			}
		}
	}


	public E max() {
		if(ElSet.isEmpty())
			return null;
		return ElSet.last();
	}

	
	public E min() {
		if(ElSet.isEmpty())
			return null;
		return ElSet.first();
	}

	
	public boolean rmFirst() throws EmptyCollectionException {
		if(ElSet.pollFirst()==null)
			throw new EmptyCollectionException();
		else
			return true;
	}

	
	public boolean rmLast() throws EmptyCollectionException {
		if(ElSet.pollLast()==null)
			throw new EmptyCollectionException();
		else 
			return true;
	}

	/* NOTE exist
	 * L'ultimo controllo IF di questo metodo controlla prima se x e y sono null in quanto 
	 * i metodi higher(e) e lower(e) restituiscono null qualora non siano presenti elementi 
	 * rispettivamente successivi o precedenti ad e, evitando quindi di chiamare il metodo 
	 * compareTo su un oggetto null (verrebbe laciata NullPointerException) e questo avverrebbe 
	 * chiamando exist(f,t) su un set avente un solo elemento uguale a f o t
	 */	
	public E exist(E f, E t) throws NullPointerException, IllegalArgumentException {
	
		if(f==null || t==null)
			throw new NullPointerException();
		else {
			if(f.compareTo(t) > 0)
				throw new IllegalArgumentException("range non valido");
			else { 
				if(ElSet.isEmpty())
					return null;
				else {
					E x = ElSet.higher(f);
					E y = ElSet.lower(t);
					if(x!=null && y!=null && x.compareTo(y) <=0)
						return x;
					else 
						return null;
				}
			}
		}	
	}
	
	
}
	
	
	
	
	
