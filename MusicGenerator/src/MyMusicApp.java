/* Megalovania:
 * "D4i D4i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
				+ "C4i C4i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
				+ "B3i B3i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
				+ "Bb3i Bb3i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i " */
/* Sugestão pra Teste: Alguma musica de Ocarina do Zelda */
/* CON(7, y) controla o volume, sendo o menor 1 e o maior 127 */

//import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
public class MyMusicApp {
	public static void main(String[] args) {
		Player player = new Player();
		Pattern pattern = new Pattern("V0 I0 D4s D4s D5i A4is Ab4s Rs G4i F4i D4s F4s G4s "
				+ ":CON(7, 64) C4s C4s D5i A4is Ab4s Rs G4i F4i D4s F4s G4s "
				+ "B3s B3s D5i A4is Ab4s Rs G4i F4i D4s F4s G4s "
				+ "Bb3s Bb3s D5i A4is Ab4s Rs G4i F4i D4s F4s G4s ");
				//+ "V1 I114 D2 D2 D2 D2 D2 D2 D2 D2 D2 D2 D2 D2 "
				//+ "D2 D2 D2 D2 ");
		player.play(pattern);
	}
}