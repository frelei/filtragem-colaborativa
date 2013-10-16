package br.ufrgs.recomendador.modulo;

public class Predito {

	private int id;
	private float predictionValue;
	
	public Predito(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPredictionValue() {
		return predictionValue;
	}
	public void setPredictionValue(float predictionValue) {
		this.predictionValue = predictionValue;
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
		Predito other = (Predito) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
