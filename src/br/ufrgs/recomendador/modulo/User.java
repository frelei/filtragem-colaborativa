package br.ufrgs.recomendador.modulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe responsável por analisar usuarios similares no
 * 	para outro usuario.
 * 	
 * @author rodrigo
 *
 */
public class User {

	private int id;
	private List<Item> item;  // Itens avaliados pelo usuario
	private List<SimilarUser> similares; 
	private float similarityRatio;	// Taxa de similaridade aceita
	
	public User(int id, float similarityRatio, List<Item> item){
		this.id = id;
		this.item = item;
		this.similarityRatio = similarityRatio;
	}

	public void findSimilares(Collection<User> users){
		this.similares = new ArrayList<SimilarUser>();
		for (User user : users) {
			if(user.getId() != this.id){
			   SimilarUser similarUser = new SimilarUser(this, user);
			   if(similarUser.getCorrelation() >= this.similarityRatio)
				   	this.similares.add(similarUser);
			}
		}
	}
	
	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}	
}