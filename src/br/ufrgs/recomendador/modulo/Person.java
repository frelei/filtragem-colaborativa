package br.ufrgs.recomendador.modulo;

import java.util.List;

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
		this.averageU1 = Average.media(u1);
		this.averageU2 = Average.media(u2);
	}	

	public float correlation(){
		float dividendo = 0 , divisorP1 = 0, divisorP2 = 0, divisor = 0;
		float corr = 0, p1 = 0, p2 = 0;	
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
		if(divisor <= 0 || dividendo <= 0 ){
			corr = 0;
		}else{
			corr = 	dividendo / divisor;
			//BigDecimal number = new BigDecimal(Float.toString(dividendo / divisor)).setScale(3,BigDecimal.ROUND_HALF_DOWN);
			//corr = number.floatValue();
		}
		return corr;
	}
	
	
	
}
