package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

	@Test
	public void reflectorConvertForwardtest() {
		Reflector r = Reflector
				.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");

		int index = 2;
		int valeurTest = r.convertForward(index);
		int expected = 20;
		assertEquals(valeurTest, expected);
		
	}

}
