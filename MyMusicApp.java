/* Megalovania:
 * "D4i D4i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
				+ "C4i C4i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
				+ "B3i B3i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
				+ "Bb3i Bb3i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i " */
/* Sugestão pra Teste: Alguma musica de Ocarina do Zelda */
/* :CON(7, y) controla o volume, sendo o menor 1 e o maior 127 */

//import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
public class MyMusicApp {
	
	public static String entradaUsuario = " QBX?DQAXGABX?DQA";
	public static String stringIntermediaria;
	public static String stringFinal;
	
	public static void main(String[] args) {
		Texto musica = new Texto();
		stringIntermediaria = musica.formataTexto(entradaUsuario);
		stringFinal = musica.textoParaMusicString(stringIntermediaria);
		Player player = new Player();
		Pattern pattern = new Pattern(stringFinal);
				//+ "V1 I114 D2 D2 D2 D2 D2 D2 D2 D2 D2 D2 D2 D2 "
				//+ "D2 D2 D2 D2 ");
		
		player.play(pattern);
	}
}
/* Zelda Lullaby: " QBX?DQAXGABX?DQA" = ":CON(7, 127) B4 R D5 A4 R G4 A4 B4 R D5 A4 R R" */