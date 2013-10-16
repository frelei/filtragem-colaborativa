package br.ufrgs.recomendador.modulo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prediction {

	//private List<Predito> itemNotCommon;
	private float averageUserWithSimilarities;
	
	public Prediction(User user){
		//this.itemNotCommon = findItemNotCommon(user);
		this.averageUserWithSimilarities = averageUserItemsCommonWithAll(user);
	}
	
	public List<Predito> findItemToRecomendation(User user){
		List<Predito> notCommon = new ArrayList<Predito>();
		
		for(SimilarUser similar : user.getSimilares()){
			for(Item i : similar.getUser().getItem())
				if(! user.getItem().contains(i)){
					if(!notCommon.contains(i)){
						Predito p = new Predito(i.getId(),averageUserWithSimilarities);
						p.calc(averageSimilarToUser(user, similar.getUser()),
								similar.getCorrelation(), i.getAvaliacao());
						notCommon.add(p);
					}else{
						Predito ref = notCommon.get(notCommon.indexOf(i));
						ref.calc(averageSimilarToUser(user, similar.getUser()),
											similar.getCorrelation(), i.getAvaliacao());
					}
				}
		}
		return notCommon;
	}
	
	/**
	 * Média das avaliações do usuário-alvo a 
	 *  considerando os artigos em comum com todos os seus similares.
	 * @param user
	 * @return
	 */
	public float averageUserItemsCommonWithAll(User user){
		Set<Item> commonWithAll = new HashSet<Item>();
		for(SimilarUser s : user.getSimilares()){
			for(Item i : s.getUser().getItem()){
				if(user.getItem().contains(i))
					commonWithAll.add(i);
			}
		}
		return Util.average(commonWithAll);
	}
	
	
	/**
	 * 
	 * Média das avaliações do usuário similar b 
	 * 	considerando artigos em comum com o usuário-alvo a.
	 * 
	 */
	public float averageSimilarToUser(User user, User similar){
		Set<Item> similarCommon = new HashSet<Item>();
		for( Item i : similar.getItem() ){
			if(user.getItem().contains(i) &&  !similarCommon.contains(i))
				similarCommon.add(i);
		}
		return Util.average(similarCommon);
	}
}
