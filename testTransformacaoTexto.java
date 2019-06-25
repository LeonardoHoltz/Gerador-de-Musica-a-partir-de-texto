import static org.junit.Assert.*;

import org.junit.Test;

public class testTransformacaoTexto {

	@Test
	public void formataPfvr() {
		Texto musiquinha = new Texto();
		assertEquals(":CON(7, 127) D4 D4 D5 A4 A4 R G4 F4 D4 F4 G4 ", musiquinha.textoParaMusicString(" QDD?DQAAXGFDFG"));
	}
	
	@Test
	public void formataPfvr2() {
		Texto musiquinha = new Texto();
		assertEquals(":CON(7, 127) B4 R D5 A4 R G4 A4 B4 R D5 A4 ", musiquinha.textoParaMusicString(" QBX?DQAXGABX?DQA"));
	}

}