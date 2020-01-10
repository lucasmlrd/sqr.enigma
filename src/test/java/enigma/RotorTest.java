package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {
	
	
	
	@Test
	public void rotorAdvanceTest() {
		Rotor r = Rotor.rotorFactory("V Z B R G I T Y U P S D N H L X A W M J Q O F E C K", "Z");
		int debut = r.getPosition();
		r.advance();
		assertEquals(debut+1, r.getPosition());
	}
	
	@Test
	public void rotorAdvanceTestLimit() {
		Rotor r = Rotor.rotorFactory("V Z B R G I T Y U P S D N H L X A W M J Q O F E C K", "Z");
		r.setPosition(25);
		r.advance();
		assertEquals(0, r.getPosition());
	}
	
	@Test
	public void rotorConvertForwardTest() {
		Rotor r = Rotor.rotorFactory("V Z B R G I T Y U P S D N H L X A W M J Q O F E C K", "Z");
		int index = 2;
		int valeurTest = r.convertForward(index);
		int expected = 1;
		assertEquals(expected, valeurTest);
	}
	
	@Test
	public void rotorConvertBackwardTest() {
		Rotor r = Rotor.rotorFactory("V Z B R G I T Y U P S D N H L X A W M J Q O F E C K", "Z");
		int index = 2;
		int valeurTest = r.convertBackward(index);
		int expected = 24;
		assertEquals(valeurTest, expected);
	}
}

