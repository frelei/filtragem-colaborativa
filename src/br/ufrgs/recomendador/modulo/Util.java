package br.ufrgs.recomendador.modulo;

import java.util.Collection;

public final class Util {

	
	/**
	 * Media dos elementos de uma lista de itens 
	 * @param item
	 * @return float
	 */
	public static float average(Collection<Item> item){
		float soma = 0;
		
		if(! item.isEmpty()){
			for (Item i : item) 
				soma += i.getAvaliacao();
			soma = soma / item.size();
		}
		
		return  soma;
	}
	
	/**
	 * Retorna uma lista de itens que há em comum entre as duas listas
	 * L1 = {1,2,3,4}
	 * L2 = {2,5,4,6}
	 * getCommon(L1,L2) = {2, 4}
	 * 
	 * @param u1
	 * @param u2
	 * @return List
	
	public static List<Item> getCommon(List<Item> u1, List<Item> u2){
		Set<Item> common1to2 = new HashSet<Item>(u1);
		common1to2.retainAll(u2);
		return new ArrayList<Item>(common1to2);
	}
	 */
}
