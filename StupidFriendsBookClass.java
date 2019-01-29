/**
 * 
 */
package thestupidfriendsbook;

/**
 * @author Miguel Goul�o
 *
 */
public class StupidFriendsBookClass implements StupidFriendsBook {
	private static final int DEFAULT = 10;
	private Person[] friends;
	private int counter;
	private int current;
	
	public StupidFriendsBookClass(){
		friends = new Person[DEFAULT];
		counter = 0;
		current = -1;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#reset()
	 */
	@Override
	public void reset() {
		counter = 0;
		current = -1;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#addFriend(java.lang.String)
	 */
	@Override
	public boolean addFriend(String name) {
		boolean canAdd = (indexOf(name) == -1);
		if (canAdd) { // new friend
			if (counter == friends.length) { // if needed, grow array
				Person[] tmp = new Person[counter * 2];
				for (int i = 0; i < counter; i++)
					tmp[i] = friends[i];
				friends = tmp;
			}
			//friends[counter++] = new PersonClass(name);
		}
		return canAdd;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#removeFriend(java.lang.String)
	 */
	@Override
	public boolean removeFriend(String name) {
		int index = indexOf(name);
		boolean canRemove = (index != -1);
		if (canRemove) {
			for (int i = index; i < counter-1; i++)
				friends[i] = friends[i+1];
			counter--;
		}
		return canRemove;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#doSomething(java.lang.String, java.lang.String)
	 */
	@Override
	public int doSomething(String name, String description) {
		int result = NO_ACTION;
		int index = indexOf(name);
		if (index != -1)
			if (friends[index].addAction(description))
				result = OK;
			else
				result = NO_FRIEND;
		return result;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#vote(java.lang.String, java.lang.String, boolean, boolean)
	 */
	@Override
	public int vote(String name, String description, boolean goodForPerson, boolean goodForOthers) {
		int result = OK; // Por omiss�o, assumimos que vai correr bem.
		int index = indexOf(name);
		if (index < 0) // Se o �ndice for < 0, � porque n�o encontramos o amigo.
			result = NO_FRIEND;
		else
		   // Se o resultado da vota��o for false, isso significa que n�o 
		   // encontramos uma ac��o com esta descri��o praticada por esta pessoa.	
		   if (!friends[index].vote(description, goodForPerson, goodForOthers))
			   result = NO_ACTION;
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#mostBoringFriend()
	 */
	@Override
	public String mostBoringFriend() {
		String name = "";
		double record = 0.0;
		if (counter > 0) {
			record = friends[0].getBoredom();
			name = friends[0].getName();
		}
		for (int i = 1; i < counter; i++)
			if (friends[i].getBoredom() < record) {
				record = friends[i].getBoredom();
				name = friends[i].getName();
			}
		
		return name;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#initialize()
	 */
	@Override
	public void initialize() {
		if (counter != 0)
			current = 0;
		else
			current = -1;
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return (current >= 0 && (current < counter));
	}
	
	/* (non-Javadoc)
	 * @see poo.StupidFriendsBook#next()
	 */
	@Override
	public Person next() {
		Person next = null;
		if (hasNext())
			next = friends[current++];
		return next;
	}
	
	private int indexOf(String name) {
		int result = -1;
		int i = 0;
		while (i < counter && result == -1) {
			if (friends[i].getName().equals(name))
				result = i;
			else
				i++;
		}
		return result;
	}

}
