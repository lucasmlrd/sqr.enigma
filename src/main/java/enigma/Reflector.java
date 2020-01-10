package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {
	
	int[] reflection;
	
	/**
	 * 
	 * @param str 
	 * @return reflecteur
	 */
	public static Reflector reflectorFactory(String str){
		char[] s = str.trim().replace(" ", "").toCharArray(); //supprime les espaces
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	private Reflector(int[] r){ 
		reflection = r;
	}
    
	/**
	 * @param p : index du tableau reflection
	 * @return (reflection[(p modulo(26)+26)modulo(26)]modulo(26)+26)modulo(26)
	 */
    public int convertForward(int p) { 
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    @Override
    public int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
