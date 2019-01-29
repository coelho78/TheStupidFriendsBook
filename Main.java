package thestupidfriendsbook;

import java.util.Scanner;

/**
 * Programa principal para demonstra��o da aplica��o TheStupidFriendsBook.
 * @author Miguel Goul�o
 * 
 * <p>Por favor, relate quaisquer falhas para <code>miguel.goulao@di.fct.unl.pt</code>
 */
public class Main {
	// Comandos do utilizador
	private static final String QUIT = "Sair";
	private static final String NEW = "Novo";
	private static final String ADD_FRIEND = "Adiciona";
	private static final String REM_FRIEND = "Remove";
	private static final String DO = "Faz";
	private static final String VOTE = "Vota";
	private static final String GOOD = "Bem";
	private static final String BAD = "Mal";
	private static final String LIST = "Lista";
	private static final String BORING = "Aborrecido";
	private static final String INTELLIGENT = "Inteligente";
	private static final String STUPID = "Est�pido";
	private static final String BANDIT = "Bandido";
	private static final String ANGEL = "Anjinho";
	
	// Feedback dado pelo programa
	private static final String PROMPT = "> ";
	private static final String OK = "Ok";
	private static final String BYE = "Adeus";
	private static final String ALREADY_EXISTS = " j� existe";
	private static final String DOES_NOT_EXIST = " n�o existe";
	private static final String NOT = " n�o ";
	
	/**
	 * Programa principal. Invoca interpretador de comandos.
	 * @param args - Argumentos para execu��o da aplica��o. N�o s�o usados, neste programa.
	 */
	public static void main(String[] args) {
		Main.commands();
	}

	/**
	 * Interpretador de comandos.
	 */
	private static void commands() {
		StupidFriendsBook fb = new StupidFriendsBookClass();
		Scanner in = new Scanner(System.in);
		String command = getCommand(in);
		// Compara��o ignorando diferen�as entre mai�sculas e min�sculas.
		while (!command.equalsIgnoreCase(Main.QUIT)) {
			if (command.equalsIgnoreCase(Main.NEW))
				Main.resetStupidFriendsBook(fb);
			else if (command.equalsIgnoreCase(Main.ADD_FRIEND))
				Main.addFriend(in, fb);
			else if (command.equalsIgnoreCase(Main.REM_FRIEND))
				Main.removeFriend(in, fb);
			else if (command.equalsIgnoreCase(Main.DO))
				Main.doSomething(in, fb);
			else if (command.equalsIgnoreCase(Main.VOTE))
				Main.vote(in, fb);
			else if (command.equalsIgnoreCase(Main.LIST))
				Main.list(in, fb);
			else if (command.equalsIgnoreCase(Main.BORING))
				Main.boring(fb);
			else
				; // N�o faz nada com comandos desconhecidos.
			command = getCommand(in);
		}
		System.out.println(Main.BYE);
	}
		
	/**
	 * Escreve uma prompt na consola e l� o comando seguinte do input, devolvendo-o
	 * @param in - O input de onde os dados v�o ser lidos.
	 * @return - O comando lido.
	 */
	private static String getCommand (Scanner in) {
		System.out.print(Main.PROMPT);
		return in.nextLine();
	}
	
	/**
	 * Limpa os registos do StupidFriendsBook
	 * @param fb - O StupidFriendsBook do qual os registos s�o apagados.
	 */
	private static void resetStupidFriendsBook(StupidFriendsBook fb) {
		fb.reset();
	}
	
	/**
	 * Adiciona um novo amigo, se ele ainda n�o existir. Se j� existir, n�o faz nada.
	 * @param in - O input de onde os dados v�o ser lidos.
	 * @param fb - O StupidFriendsBook no qual se pretende inscrever o amigo.
	 */
	private static void addFriend(Scanner in, StupidFriendsBook fb) {
		String name = in.nextLine();
		if (fb.addFriend(name))
			System.out.println(Main.OK);
		else
			System.out.println(name + Main.ALREADY_EXISTS);
	}
	
	/**
	 * Remove um amigo, se ele exisitir. Se n�o existir n�o faz nada.
	 * @param in - O input de onde os dados v�o ser lidos.
	 * @param fb - O StupidFriendsBook no qual se pretende inscrever o amigo.
	 */
	private static void removeFriend(Scanner in, StupidFriendsBook fb) {
		String name = in.nextLine();
		if (fb.removeFriend(name))
			System.out.println(Main.OK);
		else
			System.out.println(name + " " + Main.DOES_NOT_EXIST);
	}
	
	/**
	 * Acrescenta uma ac��o ao amigo. Se o amigo n�o existir, ou se existir, mas j� tiver outra ac��o com semelhante descri��o, n�o faz nada.
	 * @param in - O input de onde os dados v�o ser lidos.
	 * @param fb - O StupidFriendsBook no qual se pretende inscrever o amigo.
	 */
	private static void doSomething(Scanner in, StupidFriendsBook fb) {
		String name = in.nextLine();
		String description = in.nextLine();
		int status = fb.doSomething(name, description);
		switch (status) {
		case StupidFriendsBook.NO_FRIEND:
			System.out.println(name + Main.DOES_NOT_EXIST);
			break;
		case StupidFriendsBook.NO_ACTION:
			System.out.println(name + Main.NOT + description);
			break;
		case StupidFriendsBook.OK:
			System.out.println(Main.OK);
			break;
		}	
	}
	
	/**
	 * Vota numa ac��o de uma determinada pessoa. Se a pessoa n�o existir, ou se, existindo, n�o tiver feito essa ac��o, n�o faz nada.
	 * @param in - O input de onde os dados v�o ser lidos.
	 * @param fb - O StupidFriendsBook no qual se pretende inscrever o amigo.
	 */
	private static void vote(Scanner in, StupidFriendsBook fb) {
		String name = in.nextLine();
		String description = in.nextLine();
		boolean selfBenefit = Main.benefitStatus(in.nextLine());
		boolean othersBenefit = Main.benefitStatus(in.nextLine());
		int status = fb.vote(name, description, selfBenefit, othersBenefit);
		switch (status) {
		case StupidFriendsBook.OK:
			System.out.println(Main.OK);
			break;
		case StupidFriendsBook.NO_FRIEND:
			System.out.println(name + Main.DOES_NOT_EXIST);
			break;
		case StupidFriendsBook.NO_ACTION:
			System.out.println(name + Main.NOT + description);
			break;
		default: // Qualquer outro valor � inesperado
			break;
		}
	}
	
	/**
	 * M�todo auxiliar para transformar a <code>String</code> com a aprecia��o do impacto de uma ac��o num valor booleano.
	 * @param status - A <code>String</code> com a aprecia��o da ac��o.
	 * @return - <code>true</code>, se a ac��o for ben�fica, <code>false</code>, caso contr�rio.
	 */
	private static boolean benefitStatus(String status) {
		if (status.equalsIgnoreCase(Main.BAD))
			return false;
		else if (status.equalsIgnoreCase(Main.GOOD))
			return true;
		else
			return true; // Por omiss�o, retorna true. Nunca deve ocorrer, sendo apenas acrescentado por completude.
	}
	
	/**
	 * Lista as pessoas do StupidFriendsBook que t�m um determinado tra�o de personalidade dominante, tra�o esse a ser lido da consola.
	 * @param in - O input de onde os dados v�o ser lidos.
	 * @param fb - O StupidFriendsBook de onde vai ser retirada a listagem de pessoas.
	 */
	
	private static void list(Scanner in, StupidFriendsBook fb) {
		String result = "";
		String trait = in.nextLine();
		int personality;
		if (trait.equalsIgnoreCase(Main.INTELLIGENT))
			personality = Person.INTELLIGENT;
		else if (trait.equalsIgnoreCase(Main.STUPID))
			personality = Person.STUPID;
		else if (trait.equalsIgnoreCase(Main.BANDIT))
			personality = Person.BANDIT;
		else if (trait.equalsIgnoreCase(Main.ANGEL))
			personality = Person.ANGEL;
		else
			personality = Person.INTELLIGENT; // por omiss�o, assume-se que � inteligente. Nunca deve ocorrer.
		
		// Para listar as pessoas com um determinado tra�o, usamos o iterador de pessoas, 
		// filtrando as pessoas por personalidade, antes de as acrescentar � String que vamos imprimir.
		fb.initialize();
		while (fb.hasNext()) {
			Person p = fb.next();
			if (p.getPersonality() == personality)
				result += p.getName()+";";
		}
		System.out.println(result);
	}
	
	/**
	 * Imprime o amigo mais aborrecido de todos.
	 * @param fb - O StupidFriendsBook de onde vai ser escolhido o amigo mais aborrecido.
	 */
	private static void boring(StupidFriendsBook fb) {
		System.out.println(fb.mostBoringFriend());
	}
}
