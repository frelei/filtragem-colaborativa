package recomendador.modulo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		SimilarUser other = (SimilarUser) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimilarUser [user=" + user.getId() + ", correlation=" + correlation
				+ "]";
	}
	
	
	
}
