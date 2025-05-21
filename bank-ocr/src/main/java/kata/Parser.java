package kata;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {

    public final static String END_OF_LINE = "\n";

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
        if (zero().equals(characterToAnalyse)) {
            return "0";
        } else if (one().equals(characterToAnalyse)) {
            return "1";
        } else {
            return "2";
        }


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

    private String zero() {
        return " _ "
                + "| |"
                + "|_|";
    }

    private String one() {
        return "   "
                + "  |"
                + "  |";
    }

    private String two() {
        return "___"
                + " _|"
                + "|__";
    }
}
