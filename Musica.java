package gerasom;


/* Megalovania:
	/* "D4i D4i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
					+ "C4i C4i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
					+ "B3i B3i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i "
					+ "Bb3i Bb3i D5q A4qi Ab4i Ri G4qi F4q D4i F4i G4i " */
 /* Sugest�o pra Teste: Alguma musica de Ocarina do Zelda */
 /* :CON(7, y) controla o volume, sendo o menor 1 e o maior 127 */
import java.io.File;
import java.io.IOException;

import org.jfugue.Pattern;
import org.jfugue.Player;

public class Musica {

    public static String entradaUsuario; // = " QBX?DQAXGABX?DQA";	// fornecida pelo usu�rio
    public static String tempoBPM; // = "Vivace"; // selecionado pelo usu�rio
    public static String nomeArquivo; // = "jesus"; // fornecido pelo usu�rio
    public static Player player = new Player();

    public static void setEntradaUsuario(String entradaUsuario) {
        Musica.entradaUsuario = entradaUsuario;
    }

    public static void setTempoBPM(String tempoBPM) {
        Musica.tempoBPM = tempoBPM;
    }

    public static void setNomeArquivo(String nomeArquivo) {
        Musica.nomeArquivo = nomeArquivo;
    }

    public static void setPlayer(Player player) {
        Musica.player = player;
    }

    public static String getEntradaUsuario() {
        return entradaUsuario;
    }

    public static String getTempoBPM() {
        return tempoBPM;
    }

    public static String getNomeArquivo() {
        return nomeArquivo;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void main(String[] args) throws IOException {
//        Texto musica = new Texto();
//        stringIntermediaria = musica.formataTexto(entradaUsuario);
//        stringFinal = musica.textoParaMusicString(stringIntermediaria, tempoBPM);
//        Pattern pattern = new Pattern(stringFinal);

//        tocaMusica(pattern);
        // criacaoMidi(pattern, nomeArquivo);
    }

    public static Pattern textToPattern(String entradaUsuario, String tempoBPM) {
        Texto musica = new Texto();
        String stringIntermediaria = musica.formataTexto(entradaUsuario);
        String stringFinal = musica.textoParaMusicString(stringIntermediaria, tempoBPM);
        Pattern pattern = new Pattern(stringFinal);

        return pattern;
    }

    public static void playMusic(String entradaUsuario, String tempoBPM) {
        Player player = new Player();
        Pattern pattern = textToPattern(entradaUsuario, tempoBPM);

        if (!player.isStarted()) {
            player.play(pattern);
        }
        if (player.isPaused()) {
            player.resume();
        }
    }

    public static void createMidiFile(String entradaUsuario, String tempoBPM, String nomeArquivo) throws IOException {
        Player player = new Player();
        Pattern pattern = textToPattern(entradaUsuario, tempoBPM);

        // Adiciona extensão .mid ao nome do arquivo
        if (nomeArquivo.substring(nomeArquivo.length() - 4) != ".mid") {
            nomeArquivo = nomeArquivo + ".mid";
        }
        player.saveMidi(pattern, new File(nomeArquivo));
    }

}
/* Zelda Lullaby: " QBX?DQAXGABX?DQA" = ":CON(7, 127) B4 R D5 A4 R G4 A4 B4 R D5 A4 R R" */
