package enigma;

public class Machine {

	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private Reflector reflector;

	
	
	/**
	 * initialise le reflecteur ainsi que les rotors (droite, milieu, gauche)
	 * en prenant en entree un reflecteur, un rotor left, un rotor middle, un rotor right
	 */
	public void initRotors(Reflector reflector, Rotor left, Rotor middle, Rotor right) {
		this.reflector = reflector;
		leftRotor = left;
		middleRotor = middle;
		rightRotor = right;
	}
	
	
	/**
	 * Permet d'initialiser les positions de chaque rotor
	 * en prenant en entree une chaine de caractere de type String
	 * 
	 */

	public void setPositions(String setting) {
		char[] charSettings = setting.toCharArray();
		reflector.setPosition(Rotor.toIndex(charSettings[0]));
		leftRotor.setPosition(Rotor.toIndex(charSettings[1]));
		middleRotor.setPosition(Rotor.toIndex(charSettings[2]));
		rightRotor.setPosition(Rotor.toIndex(charSettings[3]));
	}
	
	
	/**
	 * fonction qui permet de mettre en place la machine en appelant les 2 fonctions precedentes
	 * et en prenant en entree le reflecteur, tous les rotors ainsi que les parametres
	 * a la fin, la machine self est configure
	 */
	public void configure(Reflector reflector, Rotor left, Rotor middle, Rotor right, String setting) { 
		this.initRotors(reflector, left, middle, right);
		this.setPositions(setting);

	}
	
	/**
	 * String msg en entree correspond au message à convertir a l'aide de la machine 
	 * ca return le message converti
	 */
	public String convert(String msg) {
		msg = msg.toUpperCase();
		char[] msgChars = msg.toCharArray();
		String result = "";
		for (char c : msgChars) {
			result += convertChar(c);
		}
		return result;
	}

	char convertChar(char c) {
		advanceRotors();
		int charIndex = Rotor.toIndex(c);
		int output;
		output = rightRotor.convertForward(charIndex);
		output = middleRotor.convertForward(output);
		output = leftRotor.convertForward(output);
		output = reflector.convertForward(output);
		output = leftRotor.convertBackward(output);
		output = middleRotor.convertBackward(output);
		output = rightRotor.convertBackward(output);
		return Rotor.toLetter(output);

	}

	void advanceRotors() {
		boolean advanceLeft = false;
		boolean advanceMiddle = false;
		boolean advanceRight = true;
		if (leftRotor.atNotch()) {
		}
		if (middleRotor.atNotch()) {
			advanceMiddle = true;
			advanceLeft = true;
		}
		if (rightRotor.atNotch()) {
			advanceMiddle = true;
			advanceRight = true;
		}
		if (advanceLeft) {
			leftRotor.advance();
		}
		if (advanceRight) {
			rightRotor.advance();
		}
		if (advanceMiddle) {
			middleRotor.advance();
		}
	}
}
