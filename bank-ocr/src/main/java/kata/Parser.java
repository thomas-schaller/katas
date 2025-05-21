package kata;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {

    public final static String END_OF_LINE = "\n";
    public final static String[] NOMBRE_EN_PIPE = {
            " _ "
                    + "| |"
                    + "|_|",
            "   "
                    + "  |"
                    + "  |",
            " _ "
                    + " _|"
                    + "|_ ",
            " _ " +
                    " _|" +
                    " _|",
            "   " +
                    "|_|" +
                    "  |",
            " _ " +
                    "|_ " +
                    " _|",
            " _ " +
                    "|_ " +
                    "|_|",
            " _ " +
                    "  |" +
                    "  |",
            " _ " +
                    "|_|" +
                    "|_|",
            " _ " +
                    "|_|" +
                    " _|"
    };


    public String parse(String text) {
        StringBuilder accountNumber = new StringBuilder();
        while (!text.isBlank()) {
            String characterToAnalyse = extractFirstCharacter(text);
            text = removeFirstCharacter(text);
            accountNumber.append(parseCharacter(characterToAnalyse));
        }
        return accountNumber.toString();
    }

    private String parseCharacter(String characterToAnalyse) {
        for (int nombre=0;nombre<10;nombre++)
        {
            if (NOMBRE_EN_PIPE[nombre].equals(characterToAnalyse))
            {
                return Integer.toString(nombre);
            }
        }
        return "?";

    }

    /**
     * extract the first three characteres from each line in order to retrieve the corresponding number.
     *
     * @param text
     * @return
     */
    private String extractFirstCharacter(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text, "\n");
        List<String> character = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            String line = tokenizer.nextToken();
            character.add(line.substring(0, 3));
        }
        return String.join("", character);
    }

    private String removeFirstCharacter(String text) {
        List<String> following = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(text, "\n");
        while (tokenizer.hasMoreElements()) {
            String line = tokenizer.nextToken();
            if (line.length() > 3) {
                following.add(line.substring(3));
            }
        }
        ;
        return String.join(END_OF_LINE, following);
    }
}
