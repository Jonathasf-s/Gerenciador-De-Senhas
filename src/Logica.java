import java.util.Random;

public class Logica {

    //pool
    public  static final String Lowercase_CHARACTERS= "abcdefghijklmnopqrstuvwxyz";
    public static final String UPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "01234567891";
    public static final String SIMBOLS = "!@#$%¨&*(){}[];.<,>/?";

    //IMplementaçao da clase Random :: vai escolher aleatoria mente os characteres

    private final Random random;

    public Logica(){random = new Random();}

    public String geracaoSenha(int length, boolean includeUppercase,boolean includeLowercase,boolean includeNumbers ,boolean includeSimbols) {

        // usar String builder

        StringBuilder senhaBuilder = new StringBuilder();

        // armazem de characteres validos

        String validCharacters = "";
        if (includeUppercase) validCharacters += UPERCASE_CHARACTERS;
        if (includeLowercase) validCharacters += Lowercase_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSimbols) validCharacters += SIMBOLS;

        // construindo a senha
        for (int i = 0; i<length; i++){
            // geraçao de index aleatorio
            int randomIndex = random.nextInt(validCharacters.length());

            //pegando um caracter aleatorio baseado no index aleatorio

            char randonChar = validCharacters.charAt(randomIndex);
            // alocando o character *char* no construtor de senha

            senhaBuilder.append(randonChar);

            //isso se repetirá ate que o programa preencha todos os espaços  ate  i = length
        }
        // retornando o resultado

        return senhaBuilder.toString();
    }
}
