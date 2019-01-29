/**
 * 
 */
package thestupidfriendsbook;

/**
 * @author Miguel Goul�o
 *
 */
public class ActionClass implements Action {
	/**
	 * Descri��o da ac��o
	 */
	private String description;
	
	
	/**
	 * Acumulador de votos sobre benef�cios, ou preju�zos pr�prios.
	 */
	private int selfBenefitScore;
	
	/**
	 * Acumulador de votos sobre benef�cios, ou preju�zos alheios.
	 */
	private int otherBenefitScore;
	
	/**
	 * Construtor de ActionClass. Inicialmente, uma ac��o ainda n�o foi votada e tem a descri��o passada por argumento.
	 * @param description - Descri��o da ac��o, que serve para a identificar.
	 */
	public ActionClass(String description){
		this.description = description;
		selfBenefitScore = 0;
		otherBenefitScore = 0;
	}
	
	/* (non-Javadoc)
	 * @see poo.Action#vote(boolean, boolean)
	 */
	@Override
	public void vote(boolean goodForPerson, boolean goodForOthers){
		if (goodForPerson)
			selfBenefitScore++;
		else
			selfBenefitScore--;
		if (goodForOthers)
			otherBenefitScore++;
		else
			otherBenefitScore--;
	}
	
	/* (non-Javadoc)
	 * @see poo.Action#getDescription()
	 */
	@Override
	public String getDescription(){
		return description;
	}
	
	/* (non-Javadoc)
	 * @see poo.Action#getSelfBenefit()
	 */
	@Override
	public int getSelfBenefit(){
		return selfBenefitScore;
	}
	
	/* (non-Javadoc)
	 * @see poo.Action#getOtherBenefitScore()
	 */
	@Override
	public int getOtherBenefitScore(){
		return otherBenefitScore;
	}
}
