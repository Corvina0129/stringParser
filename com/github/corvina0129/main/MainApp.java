package com.github.corvina0129.main;

import com.github.corvina0129.main.parser.Parser;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        final Parser nextlineParser = new Parser.PreparedParser("\n");
        final Parser semicolonParser = new Parser.PreparedParser(";");


        String first = "username\nuser01\nage\n16\ncity\npekin";
        String second = "id;author;hemingway;book;for whom the bell tolls;sales;9097397.0;pricePerBook;889.50";

        List<Object> parsedFirst = nextlineParser.parse(first);
        List<Object> parsedSecond = semicolonParser.parse(second);
    }
}
