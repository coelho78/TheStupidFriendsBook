package thestupidfriendsbook;

/**
 * @author Miguel Goul�o
 *
 */
public interface StupidFriendsBook {
	// Constantes com c�digos de erro
	public static final int OK = 0;
	public static final int NO_FRIEND = -1;
	public static final int NO_ACTION = -2;

	/**
	 * Limpa a lista de amigos
	 */
	void reset();

	/**
	 * Adiciona o amigo de nome <code>name</code>. Se j� existir, n�o faz nada.
	 * @param name - nome do amigo a adicionar � rede social
	 * @return <code>true</code>, se conseguir adicionar o amigo, 
	 * ou <code>false</code>, se o amigo j� existe
	 */
	boolean addFriend(String name);

	/**
	 * Remove o amigo de nome name. Se o amigo n�o existir, n�o faz nada.
	 * @param name - nome do amigo a remover.
	 * @return  <code>true</code>, se conseguir, ou <code>false</code>, 
	 * se o amigo n�o existir.
	 */
	boolean removeFriend(String name);

	/**
	 * Acrescenta a ac��o description � pessoa de nome <code>name</code>.
	 * @param name - nome da pessoa cuja ac��o vai ser registada
	 * @param description - descri��o da ac��o a ser registada
	 * @return <code>OK</code>, se acrescentar a ac��o com sucesso, 
	 * <p><code>NO_ACTION</code>, se o comando falhar porque a pessoa j� tinha essa ac��o, ou 
	 * <p><code>NO_FRIEND</code>, se a pessoa n�o existir.
	 */
	int doSomething(String name, String description);

	/**
	 * Vota numa ac��o praticada pela pessoa de nome <code>name</code>, com a
	 * descri��o <code>description</code>, indicando se ela � positiva, ou 
	 * negativa, para o pr�ximo e para outras pessoas.
	 * @param name - nome da pessoa cuja ac��o vai ser votada
	 * @param description - descri��o da ac��o que vai ser votada
	 * @param goodForPerson - indica��o sobre a ac��o ser positiva (<code>true</code>) ou negativa para o pr�prio
	 * @param goodForOthers - indica��o sobre a ac��o ser positiva (<code>true</code>) ou negativa para os outros
	 * @return <code>OK</code>, se votar na ac��o com sucesso, 
	 * <p><code>NO_ACTION</code>, se o voto falhar por n�o existir a ac��o, ou 
	 * <p><code>NO_FRIEND</code>, se o voto falhar por n�o existir a pessoa.
	 */
	int vote(String name, String description,
			boolean goodForPerson, boolean goodForOthers);

	/**
	 * Devolve o nome da pessoa mais aborrecida, ou a String vazia, 
	 * se n�o houver amigos
	 * @return String com o nome da pessoa mais aborrecida, se existir, ou a
	 * String vazia, se n�o existirem amigos
	 */
	String mostBoringFriend();

	/**
	 * Inicializa o iterador de amigos
	 */
	void initialize();

	/**
	 * Verifica se existem mais pessoas a iterar.
	 * @return <code>true</code> se houver mais pessoas a iterar, 
	 * ou <code>false</code> caso contr�rio.
	 */
	boolean hasNext();

	/**
	 * Devolve a pr�xima pessoa a iterar, avan�ando com o iterador, 
	 * ou <code>null</code>, se n�o houver mais pessoas para iterar
	 * @return a pr�xima pessoa, se existir, ou <code>null</code>, caso contr�rio.
	 */
	Person next();
}