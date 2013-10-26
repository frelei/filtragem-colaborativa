package recomendador.modulo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Calcula a similaridade entre dois usuarios
 * Observação - deve ser passada listas que contenham os mesmos elementos
 * 
 * @author rodrigo
 *
 */

public class Person {

	private List<Item> u1;
	private List<Item> u2;
	private float averageU1;
	private float averageU2;
	
	public Person(List<Item> u1, List<Item> u2){
		this.u1 = u1;
		this.u2 = u2;
		this.averageU1 = Util.average( getCommon(u1, u2) );
		this.averageU2 = Util.average( getCommon(u2, u1) );
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
	 */
	public List<Item> getCommon(List<Item> u1, List<Item> u2){
		Set<Item> common1to2 = new HashSet<Item>(u1);
		common1to2.retainAll(u2);
		return new ArrayList<Item>(common1to2);
	}
	
	
	public float correlation(){
		float dividendo = 0 , divisorP1 = 0, divisorP2 = 0, divisor = 0, corr = 0;
		float p1 = 0, p2 = 0;	
		int index = 0;
		
		for (Item i1 : u1) {
			index = u2.indexOf(i1);
			if(index != -1){
				Item i2 = u2.get(index);
				p1 = i1.getAvaliacao() - averageU1;
				p2 = i2.getAvaliacao() - averageU2;
				dividendo +=  p1 * p2;
				divisorP1 += Math.pow(p1, 2);
				divisorP2 += Math.pow(p2, 2);
			}
		}
		divisor = (float) ( Math.sqrt( (divisorP1 * divisorP2) ) ); 
		if(divisor == 0 || dividendo == 0 ){
			corr = 0; 
		}else{
			corr = 	dividendo / divisor;
			//BigDecimal number = new BigDecimal(Float.toString(dividendo / divisor)).setScale(3,BigDecimal.ROUND_HALF_DOWN);
			//corr = number.floatValue();
		}
		return corr;
	}
	
}
