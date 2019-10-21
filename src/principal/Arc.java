package principal;

public class Arc<T> {
	
	private Nodo<T> destiny;
	private Nodo<T> origin;
	private int peso;
	
	
	public Arc(Nodo<T> pDestiny,Nodo<T> pOrigin, int pPeso) {
		destiny=pDestiny;
		origin=pOrigin;
		peso=pPeso;
		
	}	
	
	public Nodo<T> getDestiny() {
		return destiny;
	}


	public void setDestiny(Nodo<T> destiny) {
		this.destiny = destiny;
	}


	public Nodo<T> getOrigin() {
		return origin;
	}


	public void setOrigin(Nodo<T> origin) {
		this.origin = origin;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}

}
