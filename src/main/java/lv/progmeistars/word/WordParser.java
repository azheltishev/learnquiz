package lv.progmeistars.word;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordParser {

    String pattern = "\\(See #(\\d)+\\)";

    public List<String> parse(String rawWords) {
        if (rawWords.startsWith("\"") && rawWords.endsWith("\"")) {
            return handleMultipleWords(rawWords);
        } else {
            return List.of(clean(rawWords));
        }
    }

    private String clean(String s) {
        return s.replaceAll(pattern, "")
                .replaceAll("; masterrussian", "")
                .replaceAll("dot com", "")
                .replaceAll("dot", "")
                .replaceAll("com", "")
                .trim();
    }

    private List<String> handleMultipleWords(String rawWords) {
        var words = rawWords.substring(1, rawWords.length() - 1);

        return Arrays.stream(words.split(","))
                     .map(this::clean)
                     .filter(s -> !s.isBlank())
                     .collect(Collectors.toList());
    }
}
