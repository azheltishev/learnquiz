package lv.progmeistars;

import lv.progmeistars.parser.CsvParser;
import lv.progmeistars.parser.WordTranslationTypeData;
import lv.progmeistars.word.WordParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        var wordParser = new WordParser();
        var parser = new CsvParser();
        Random random = new Random();

        var file = Main.class.getClassLoader().getResource("words.csv").getFile();
        var list = parser.parseFile(new File(file));

        int size = list.size();
        var askedWords = new ArrayList<WordTranslationTypeData>();
        for (int i = 0; i < 5; i++) {
            askedWords.add(list.get(random.nextInt(size)));
        }


        int score = 0;
        Scanner scanner = new Scanner(System.in);
        for (WordTranslationTypeData data : askedWords) {
            System.out.println(data.getSourceLanguage());
            String next = scanner.next();

            List<String> parsedTranslations = wordParser.parse(data.getTranslationLanguage());
            if (data.getTranslationLanguage().contains(next.strip())) {
                System.out.println("correct!");
                score++;
            } else {
                System.out.printf("wrong translation, correct would be : %s !%n", parsedTranslations);
            }
        }

        System.out.println("you scored " + score + " out of 5");
    }
}
