/**
 * 
 */
package thestupidfriendsbook;

/**
 * @author Miguel Goul�o
 *
 */
public interface Action {
	/**
	 * Vota numa ac��o. Actualiza os valores acumulados da vota��o.
	 * @param goodForPerson - <code>true</code>, se a ac��o for ben�fica para o pr�prio, <code>false</code> caso contr�rio.
	 * @param goodForOthers - <code>true</code>, se a ac��o for ben�fica para os outros, <code>false</code> caso contr�rio.
	 */
	void vote(boolean goodForPerson, boolean goodForOthers);
	
	/**
	 * Devolve a descri��o de uma ac��o, que a identifica.
	 * @return - A descri��o da ac��o.
	 */
	String getDescription();
	
	/**
	 * Devolve a diferen�a entre o n�mero de pessoas que consideram a ac��o ben�fica para o pr�prio, e prejudicial para o pr�prio
	 * @return - os votos acumulados
	 */
	int getSelfBenefit();
	/**
	 * Devolve a diferen�a entre o n�mero de pessoas que consideram a ac��o ben�fica para os outros, e prejudicial para os outros
	 * @return
	 */
	int getOtherBenefitScore();
}
