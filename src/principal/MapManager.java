package principal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Queue;



public class MapManager extends Observable {
	private Graph<Point> grafo;
	private Nodo<Point> anterior;
	public MapManager() {
		grafo=new Graph<Point>();
		anterior=null;
	}
	
	public void agregarPunto(int pX,int pY) {
		Point punto=new Point(pX,pY);
		Nodo<Point> nodopunto=grafo.agregaNodo(punto);
		if (anterior==null) {
			anterior=nodopunto;
		}else {
			grafo.agregararco(anterior, nodopunto);
		}
		
		this.setChanged();
		this.notifyObservers(nodopunto);
	}
	
	public Graph<Point> getGrafo() {
		return grafo;
	}

	public void setGrafo(Graph<Point> grafo) {
		this.grafo = grafo;
	}

	public Nodo<Point> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<Point> anterior) {
		this.anterior = anterior;
	}

	public Nodo<Point> RecorridoEnAnchura(Nodo<Point> nodoABuscar) {
		ArrayDeque<Nodo<Point>> coladenods=new ArrayDeque<Nodo<Point>>();
		Nodo<Point> nodo=grafo.getNodos().get(0);
		coladenods.add(nodo);
		nodo.setMarcado(true);
		while(!coladenods.isEmpty()) {
			Nodo<Point> w=coladenods.poll();
			for(Arc<Point> arco : w.getArcos()) {
				if(!arco.getDestiny().isMarcado()) {
					coladenods.add(arco.getDestiny());
					arco.getDestiny().setMarcado(true);
					arco.getDestiny().setAnterior(w);
				}
			}
		}
		return nodoABuscar;
	}
}
