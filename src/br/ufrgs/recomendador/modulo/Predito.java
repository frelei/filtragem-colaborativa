package br.ufrgs.recomendador.modulo;


public class Predito {

	private int id;
	private float averageUserBySimilarities;
	private float dividendo = 0;
	private float divisor  = 0;
	
	// construtores
	public Predito(int id){
		this.id = id;
	}
		
	public Predito(int id, float averageUserBySimilarities ) {
		this.id = id;
		this.averageUserBySimilarities = averageUserBySimilarities;
	}
	
	public void calc(float rb, float corr, int avaliation){
		this.dividendo += (avaliation - rb) * corr;
		this.dividendo += Math.abs(corr); 
	}
	
	// getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Retorna a predição do Item(id)
	 * @return float
	 */
	public float getPrediction() {
		return this.averageUserBySimilarities + this.dividendo / this.divisor;
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
