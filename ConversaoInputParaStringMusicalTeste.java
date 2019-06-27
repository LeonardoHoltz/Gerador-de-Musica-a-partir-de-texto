package gerasom;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversaoInputParaStringMusicalTeste {

	@Test
	public void transformacaoTeste1() {
		Texto musiquinha = new Texto();
		assertEquals("T[Vivace] :CON(7, 127) D4 D4 D5 A4 A4 R G4 F4 D4 F4 G4 ", musiquinha.textoParaMusicString(" QDD?DQAAXGFDFG", "Vivace"));
	}
	
	@Test
	public void transformacaoTeste2() {
		Texto musiquinha = new Texto();
		assertEquals("T[Moderato] :CON(7, 127) B4 R D5 A4 R G4 A4 B4 R D5 A4 ", musiquinha.textoParaMusicString(" QBX?DQAXGABX?DQA", "Moderato"));
	}
	
	@Test
	public void transformacaoTeste3() {
		Texto musiquinha = new Texto();
		assertEquals("T[Allegro] :CON(7, 127) A5 A5 R R ", musiquinha.textoParaMusicString(" AAXX", "Allegro"));
	}
	
	@Test
	public void formatacaoTeste1() {
		Texto musiquinha = new Texto();
		assertEquals(" AAXX", musiquinha.formataTexto(" Appp"));
	}
	
	@Test
	public void formatacaoTeste2() {
		Texto musiquinha = new Texto();
		assertEquals(" AAXXBBX", musiquinha.formataTexto(" AkkkByy"));
	}
	
	@Test
	public void formatacaoTeste3() {
		Texto musiquinha = new Texto();
		assertEquals(" AAXXBBXCDD", musiquinha.formataTexto(" AkkkByyCDt"));
	}

}