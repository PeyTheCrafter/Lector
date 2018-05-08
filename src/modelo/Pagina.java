package modelo;

public class Pagina {
	private int numero;
	private long primer;
	private long ultimo;

	public Pagina(int numero, long primer, long ultimo) {
		super();
		this.numero = numero;
		this.primer = primer;
		this.ultimo = ultimo;
	}

	public long getPrimer() {
		return primer;
	}

	public void setPrimer(long primer) {
		this.primer = primer;
	}

	public long getUltimo() {
		return ultimo;
	}

	public void setUltimo(long ultimo) {
		this.ultimo = ultimo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
