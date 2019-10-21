package principal;

import java.util.ArrayList;

public class Graph<T> {
	private ArrayList<Nodo<T>> nodos;
	private ArrayList<Arc<T>> arcos;
	
	
	public Graph() {
		nodos=new ArrayList<Nodo<T>>();
		arcos=new ArrayList<Arc<T>>();
		
	}
	
	public Nodo agregaNodo(T pValue) {
		Nodo<T> nuevo=new Nodo(pValue);
		nodos.add(nuevo);
		return nuevo;
	} 
	
	public ArrayList<Nodo<T>> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Nodo<T>> nodos) {
		this.nodos = nodos;
	}

	public ArrayList<Arc<T>> getArcos() {
		return arcos;
	}

	public void setArcos(ArrayList<Arc<T>> arcos) {
		this.arcos = arcos;
	}

	public void agregararco(Nodo<T> pOrigen, Nodo<T> pDestino) {
		Arc<T> nuevo=new Arc<T>(pOrigen,pDestino,0);
		arcos.add(nuevo);
		pOrigen.getArcos().add(nuevo);
		
		nuevo=new Arc<T>(pDestino, pOrigen,0);
		arcos.add(nuevo);
		pDestino.getArcos().add(nuevo);
	}
	
	
	

	
	
}
