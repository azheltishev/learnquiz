package lv.progmeistars.word;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class WordParserTest {

    WordParser target = new WordParser();

    @Test
    void shouldParse() {
        assertLinesMatch(List.of("alike", "in like manner"), target.parse("\"alike, in like manner\""));
        assertLinesMatch(List.of("little", "few"), target.parse("\"little, few, (See #630)\""));
        assertLinesMatch(List.of("to play"), target.parse("to play"));
        assertLinesMatch(List.of("here"), target.parse("here"));
        assertLinesMatch(List.of("to believe"), target.parse("\"to believe; masterrussian, dot com\""));
        assertLinesMatch(List.of("bride"), target.parse("bride (See #288)"));
    }

}
