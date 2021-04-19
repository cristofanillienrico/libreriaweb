package it.prova.libreriaweb.model;

public class Libro {
	private String titolo;
	private String genere;
	private String pagine;

	public Libro(String titolo, String genere, String pagine) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.pagine = pagine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getPagine() {
		return pagine;
	}

	public void setPagine(String pagine) {
		this.pagine = pagine;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", genere=" + genere + ", pagine=" + pagine + "]";
	}
	

}
