package lv.progmeistars;

import lv.progmeistars.parser.CsvParser;
import lv.progmeistars.parser.WordTranslationTypeData;
import lv.progmeistars.word.WordParser;

import java.io.File;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        var wordParser = new WordParser();
        var parser = new CsvParser();

        var file = Main.class.getClassLoader().getResource("words.csv").getFile();
        var list = parser.parseFile(new File(file));

        for (WordTranslationTypeData data : list) {
            List<String> parsedTranslations = wordParser.parse(data.getTranslationLanguage());
            System.out.printf("%s | %s%n", data.getSourceLanguage(), String.join(",", parsedTranslations));
        }
    }
}
