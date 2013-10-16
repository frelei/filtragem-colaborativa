package br.ufrgs.recomendador.modulo;


/**
 * Representa Objeto para filtragem colaborativa  
 * 
 * @author rodrigo
 *
 */

public class Item {

	private int id; // identificador
	private int avaliacao; // avaliação
	
	
	public Item(int id, int avaliacao){
		this.id = id;
		setAvaliacao(avaliacao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		if(avaliacao <= 0)
			this.avaliacao = 0;
		else
			this.avaliacao = avaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", avaliacao=" + avaliacao + "]";
	}
	
	
	
}