package br.ufrgs.recomendador.modulo;

import java.util.List;

public class Collaboration {

	private List<Predito> preditos;
	
	public Collaboration(User user, List<User> base){
		user.findSimilares(base);
		this.preditos = new Prediction(user).findItemToRecomendation();
	}

	/**
	 * Retorna lista de preditos
	 * @return
	 */
	public List<Predito> getPreditos() {
		return preditos;
	}
		
}
