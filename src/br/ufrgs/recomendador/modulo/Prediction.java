package br.ufrgs.recomendador.modulo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prediction {

	private User user;
	
	public Prediction(User user){
		this.user = user;
	}
	
	public List<Predito> findItemToRecomendation(){
		List<Predito> notCommon = new ArrayList<Predito>();
		float averageUserWithSimilarities = averageUserItemsCommonWithAll(user);
		
		for(SimilarUser similar : user.getSimilares()){
			for(Item i : similar.getUser().getItem())
				if(! user.getItem().contains(i)){
					Predito p = new Predito(i.getId(),averageUserWithSimilarities);
					if(! notCommon.contains(p)){
						p.calc(averageSimilarToUser(user, similar.getUser()),
								similar.getCorrelation(), i.getAvaliacao());
						notCommon.add(p);
					}else{
						Predito ref = notCommon.get(notCommon.indexOf(p));
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
	public static float averageUserItemsCommonWithAll(User user){
		Set<Item> commonWithAll = new HashSet<Item>();
		int index = 0;
		for(SimilarUser s : user.getSimilares()){
			for(Item i : s.getUser().getItem()){
				index = user.getItem().indexOf(i);
				if(index != -1)
					commonWithAll.add(user.getItem().get(index));
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
	public static float averageSimilarToUser(User user, User similar){
		Set<Item> similarCommon = new HashSet<Item>();
		
		for( Item i : similar.getItem() ){
			if(user.getItem().contains(i) && !similarCommon.contains(i)){
				similarCommon.add(i);
			}
		}
		return Util.average(similarCommon);
	}

	

}