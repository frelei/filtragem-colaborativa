package br.ufrgs.recomendador.modulo;

/**
 * Estrutura Guarda usuario similar a outro usuario 
 * 	e seu grau similaridade
 * @author rodrigo
 *
 */
public class SimilarUser {

	private User user; 
	private float correlation; // valor entre source e target
	
	public SimilarUser(User source, User target){
		this.user = target;
		this.correlation = new Person(source.getItem(), target.getItem()).correlation();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getCorrelation() {
		return correlation;
	}

	public void setCorrelation(float correlation) {
		this.correlation = correlation;
	}
}
