# String Parser

The input is a non-empty string. Data in the string can be separated by any delimiter, such as whitespace, comma, \n, etc. The parser parses the string into 4 types: char, bool, string, double. Returns a list of objects.

## Using a prepared parser

There are a couple of parser implementations. The easiest way is to use the prepared version with a built-in splitter and converter.

```java
final Parser nextlineParser = new Parser.PreparedParser("\n");
final Parser semicolonParser = new Parser.PreparedParser(";");
```

Now the parser is ready to use.

```java
final String first = "username\nuser01\nage\n16\ncity\npekin";
final String second = "id;author;hemingway;book;for whom the bell tolls;sales;9097397.0;pricePerBook;889.50";

List<Object> parsedFirst = nextlineParser.parse(first);
// [username, user01, age, 16.0, city, pekin]
List<Object> parsedSecond = semicolonParser.parse(second);
// [id, author, hemingway, book, for whom the bell tolls, sales, 9097397.0, pricePerBook, 889.5]
```

## Using a base parser

Firstly, we need to create splitter and converter with pairs of typedefiner and typeconverter.

```java
final Splitter splitter = new Splitter.Base();
        
final Converter converter = new Converter.Base(Arrays.asList(
      Pair.of(new NumberTypeDefiner(), new NumberTypeConverter()),
      Pair.of(new StringTypeDefiner(), new StringTypeConverter()),
      Pair.of(new CharTypeDefiner(), new CharTypeConverter()),
      Pair.of(new BooleanTypeDefiner(), new BooleanTypeConverter())
));
```

Secondly, create parser and pass it a delimiter and a converter as arguments.

```java
final Parser nextlineParser = new Parser.Base("\n", splitter, converter);
final Parser semicolonParser = new Parser.Base(";", splitter, converter);
```

And after that the parser is resdy.
