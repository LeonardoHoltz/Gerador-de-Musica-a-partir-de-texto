package gerasom;

import java.io.File;
import java.io.IOException;

import org.jfugue.Pattern;
import org.jfugue.Player;

public class Musica {

    public static String entradaUsuario;
    public static String tempoBPM;
    public static String nomeArquivo;
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

