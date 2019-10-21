package principal;

import java.util.ArrayList;

public class Nodo<T> {
	private T value;
	private ArrayList<Arc<T>> arcos;
	private Nodo anterior;
	private boolean visitada;
	private boolean marcado;
	
	
	public Nodo(T pValue) {
		value=pValue;
		anterior=null;
		arcos = new ArrayList<Arc<T>>();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Nodo getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}

	public boolean isVisitada() {
		return visitada;
	}

	public void setVisitada(boolean visitada) {
		this.visitada = visitada;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	public ArrayList<Arc<T>> getArcos() {
		return arcos;
	}
	
	
}
