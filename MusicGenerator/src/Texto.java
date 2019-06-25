import java.lang.Character;

public class Texto {
	
	private static char oitava;
	private static int instrumento;
	private static String instrumentoString;
	private static final char OITAVA_DEFAULT = '5';
	private static final int INSTRUMENTO_DEFAULT = 0;
	
	public static boolean charValido(char caractere) {
		// True se o caractere altera algo na música, false caso o contrário
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
			case '?':
			case '.':
			case '!':	
			case '\n':
			case ';':
			case ',':
				return true;
			default:
				return false;
		}
	}
	
	private static boolean ehNota(char caractere) {
		// True se o char é uma nota válida, false caso o contrário
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

	public static String formataTexto(String inputTexto) {
		char[] textoFormatado = inputTexto.toCharArray();
		for(int i = 0; i < textoFormatado.length; i++) {
			if(i == 0) {
				if(!charValido(textoFormatado[i]))
					textoFormatado[i] = 'X';	// O caractere X indicará uma pausa
			}
			else {
				if(!charValido(textoFormatado[i])) {
					if(ehNota(textoFormatado[i-1]))
						textoFormatado[i] = textoFormatado[i-1];
					else
						textoFormatado[i] = 'X';
				}
			}
		}
		String textoFormatadoFinal = new String(textoFormatado);
		return textoFormatadoFinal;
	}
	
	
	public static String textoParaMusicString(String textoFormatado) {
		char[] textoFormatadoChar = textoFormatado.toCharArray();
		StringBuilder arrayMusical = new StringBuilder();
		oitava = OITAVA_DEFAULT;
		instrumento = INSTRUMENTO_DEFAULT;
		for(int i = 0; i < textoFormatadoChar.length; i++) {
			if(ehNota(textoFormatadoChar[i])) {
				// Padrão estipulado: Oitavas sempre serão concatenadas com as notas musicais
				arrayMusical.append(textoFormatadoChar[i]);
				arrayMusical.append(oitava);
				arrayMusical.append(' ');
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
				if(instrumento == 127) // Se esta no último instrumento, volta para o piano
					instrumento = Character.getNumericValue(textoFormatadoChar[i]) - 1;
				else					// Se não, vai para o próximo.
					instrumento = instrumento + Character.getNumericValue(textoFormatadoChar[i]);
			}
			if(textoFormatadoChar[i] == '?') { // Aumeta a oitava em 1
				if(oitava == '9')
					oitava = OITAVA_DEFAULT;
				else {							//ARRUMAR ESSA PORRA
					oitava++;
				}
			}
			if(textoFormatadoChar[i] == ' ') {
				if(volume * 2 >= 127)
					volume = 127
			}
		}
		String stringMusical = arrayMusical.toString();
		
		return stringMusical;
	}


}
