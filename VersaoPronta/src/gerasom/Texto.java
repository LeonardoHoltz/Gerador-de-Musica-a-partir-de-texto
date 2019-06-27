package gerasom;

import java.lang.Character;

public class Texto {
	
	private static String oitava;
	private static int oitavaInt;
	private static int instrumento;
	private static String instrumentoString;
	private static int volume;
	private static String volumeString;
	private static final String OITAVA_DEFAULT = "5";
	private static final int INSTRUMENTO_DEFAULT = 0;
	private static final int VOLUME_DEFAULT = 127;
	public static String stringMusical;
	
	public static boolean charValido(char caractere) {
		// True se o caractere altera algo na masica, false caso o contrario
		switch (caractere) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case ' ':
			case 'I':
			case 'i':
			case 'O':
			case 'o':
			case 'U':
			case 'u':
			case '?': // Aumenta oitava
			case 'Q': // Diminui oitava
			case '.':
			case '!':	
			case '\n':
			case ';':
			case ',':
			case 'X': // Pausa
				return true;
			default:
				return false;
		}
	}
	
	private static boolean ehNota(char caractere) {
		// True se o char for uma nota valida, false caso o contrario
		switch (caractere) {
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
				return true;
			default:
				return false;
		}
	}

	public String formataTexto(String inputTexto) {
		char[] textoFormatado = inputTexto.toCharArray();
		boolean ultimoCharEhNota = false;
		for(int i = 0; i < textoFormatado.length; i++) {
			if(i == 0) {
				if(!charValido(textoFormatado[i]))
					textoFormatado[i] = 'X';	// O caractere X indicara uma pausa
			}
			else {
				if(!charValido(textoFormatado[i])) {
					if(ehNota(textoFormatado[i-1])) {
						if(!ultimoCharEhNota) {
							textoFormatado[i] = textoFormatado[i-1];
							ultimoCharEhNota = true;
						}
						else {
							textoFormatado[i] = 'X';
							ultimoCharEhNota = false;
						}
					}
					else
						textoFormatado[i] = 'X';
				}
			}
		}
		String textoFormatadoFinal = new String(textoFormatado);
		return textoFormatadoFinal;
	}
	
	private static boolean ehOutraVogal(char c) {
		switch (c) {
			case 'I':
			case 'i':
			case 'O':
			case 'o':
			case 'U':
			case 'u':
				return true;
			default:
				return false;
		}
	}
	
	
	public String textoParaMusicString(String textoFormatado, String tempoBPM) {
		char[] textoFormatadoChar = textoFormatado.toCharArray();
		StringBuilder arrayMusical = new StringBuilder();
		oitava = OITAVA_DEFAULT;
		instrumento = INSTRUMENTO_DEFAULT;
		volume = VOLUME_DEFAULT;
		arrayMusical.append("T[" + tempoBPM + "] ");
		for(int i = 0; i < textoFormatadoChar.length; i++) {
			if(ehNota(textoFormatadoChar[i])) {
				// Padrao estipulado: Oitavas sempre serao concatenadas com as notas musicais
				arrayMusical.append(textoFormatadoChar[i]);
				arrayMusical.append(oitava + " ");
			}
			if(textoFormatadoChar[i] == 'X') {
				arrayMusical.append('R'); // Rest (pausa)
				arrayMusical.append(' ');
			}
			if(textoFormatadoChar[i] == '!') { // Muda instrumento para Harpsichord
				instrumento = 6;
				instrumentoString = Integer.toString(instrumento);
				arrayMusical.append("I" + instrumentoString);
				arrayMusical.append(' ');
			}
			if(textoFormatadoChar[i] == ';') { // Muda instrumento para Pan Flute
				instrumento = 75;
				instrumentoString = Integer.toString(instrumento);
				arrayMusical.append("I" + instrumentoString);
				arrayMusical.append(' ');
			}
			if(textoFormatadoChar[i] == '\n') { // Muda instrumento para Tubular Bells
				instrumento = 14;
				instrumentoString = Integer.toString(instrumento);
				arrayMusical.append("I" + instrumentoString);
				arrayMusical.append(' ');
			}
			if(textoFormatadoChar[i] == ',') { // Muda instrumento para Tubular Bells
				instrumento = 19;
				instrumentoString = Integer.toString(instrumento);
				arrayMusical.append("I" + instrumentoString);
				arrayMusical.append(' ');
			}
			if (Character.isDigit(textoFormatadoChar[i])) {
				if(instrumento == 127) // Se esta no ultimo instrumento, volta para o piano
					instrumento = Character.getNumericValue(textoFormatadoChar[i]) - 1;
				else					// Se n�o, vai para o pr�ximo.
					instrumento = instrumento + Character.getNumericValue(textoFormatadoChar[i]);
			}
			if(textoFormatadoChar[i] == '?') { // Aumeta a oitava em 1
				if(oitava == "9")
					oitava = OITAVA_DEFAULT;
				else {
					oitavaInt = Integer.parseInt(oitava);
					oitavaInt++;
					oitava = Integer.toString(oitavaInt);
				}
			}
			if(textoFormatadoChar[i] == 'Q') { // Diminui a oitava em 1
				if(oitava == "1")
					oitava = OITAVA_DEFAULT;
				else {
					oitavaInt = Integer.parseInt(oitava);
					oitavaInt--;
					oitava = Integer.toString(oitavaInt);
				}
			}
			if(textoFormatadoChar[i] == ' ') {
				if(volume * 2 >= 127)
					volume = 127;
				else
					volume = volume * 2;
				volumeString = ":CON(7, " + Integer.toString(volume) + ") ";
				arrayMusical.append(volumeString);
			}
			if(ehOutraVogal(textoFormatadoChar[i])) {
				if(volume + 12 >= 127)
					volume = 127;
				else
					volume = volume + 12;
				volumeString = ":CON(7, " + Integer.toString(volume) + ") ";
				arrayMusical.append(volumeString);
			}
		}
		stringMusical = arrayMusical.toString();
		return stringMusical;
		
	}
	
}
