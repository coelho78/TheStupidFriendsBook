package thestupidfriendsbook;

/**
 * @author Miguel Goul�o
 *
 */
public interface Person {
	// Constantes de perfis de personalidade
	int INTELLIGENT = 0;
	int ANGEL = 1;
	int BANDIT = 2;
	int STUPID = 3;

	/**
	 * Acrescenta uma ac��o <code>description</code> � pessoa, desde que ela 
	 * ainda n�o a tenha.
	 * @param description - descri��o da ac��o.
	 * @return Devolve <code>true</code> se a ac��o � acrescentada, 
	 * ou <code>false</code>, se j� existe uma ac��o com a mesma descri��o.
	 */
	boolean addAction(String description);

	/**
	 * Vota na ac��o, incrementando os votos nos benef�cios pr�prios 
	 * se <code>goodForPerson</code> for <code>true</code>, ou decrementando-os, 
	 * caso contr�rio, e fazendo o mesmo em rela��o aos benef�cios alheios, 
	 * com o argumento <code>goodForOthers</code>.
	 * @param description - descri��o da ac��o a votar
	 * @param goodForPerson - <code>true</code>, se for ben�fico para o pr�prio, <code>false</code> caso contr�rio
	 * @param goodForOthers - <code>true</code>, se for ben�fico para os outros, <code>false</code> caso contr�rio
	 * @return <code>true</code>, se for poss�vel votar, <code>false</code> caso contr�rio.
	 */
	boolean vote(String description, boolean goodForPerson,	boolean goodForOthers);

	/**
	 * Devolve o nome da pessoa
	 * @return - o nome da pessoa.
	 */
	String getName();

	/**
	 * Devolve a personalidade dominante da pessoa.
	 * @return Devolve um inteiro representando o tra�o de personalidade dominante, 
	 * com os valores <code>INTELIGENT</code>, <code>STUPID</code>, 
	 * <code>BANDIT</code>, ou <code>ANGEL</code>.
	 */
	int getPersonality();

	/**
	 * Devolve o valor da �dist�ncia� dos votos acumulados � origem usando o 
	 * teorema de Pit�goras, sendo a �dist�ncia� a �hipotenusa� e os valores 
	 * acumulados de benef�cios pr�prios e alheios os �catetos�
	 * @return O valor calculado.
	 */
	double getBoredom();
}