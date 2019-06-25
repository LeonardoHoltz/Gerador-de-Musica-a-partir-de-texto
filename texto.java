
public class texto {
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
	
}
