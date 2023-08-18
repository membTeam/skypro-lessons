package lessons;

import devlInterface.IRunLesson;
import lessons.modelForLesson.Ls12Author;
import lessons.modelForLesson.Ls12AuthorGr;
import lessons.modelForLesson.Ls12Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static devlAPI.APIprintService.*;


public class Lesson12 implements IRunLesson {

    private static HashMap<Integer, Ls12AuthorGr> hashMap;
    private static ArrayList<Ls12Book> lsBooks;

    private static boolean loadBooks() {
        boolean res = false;

        hashMap = new HashMap<Integer, Ls12AuthorGr>();
        lsBooks = new ArrayList<>();

        try (var reader = new BufferedReader(new FileReader("textLessons/ls12.txt"))) {

            String line = "";
            int id = 1;

            String strPattern = "(\\W+)(\\d{4})(.+)";
            Pattern pattern = Pattern.compile(strPattern);

            while ((line = reader.readLine()) != null && !(line.isEmpty())) {
                if (line.charAt(0) == '#') {
                    continue;
                }

                var matcher = pattern.matcher(line);
                if (matcher.find()) {
                    var arr = matcher.group(1).split(" ");
                    var ls12Author = new Ls12Author(arr[0], arr[1]);

                    var hashAuthor = ls12Author.hashCode();

                    if (hashMap.containsKey(hashAuthor)) {
                        var ls12AuthorGr = hashMap.get(hashAuthor);
                        ls12AuthorGr.setCountAuthor();
                    } else {
                        hashMap.put(hashAuthor, new Ls12AuthorGr(ls12Author));
                    }

                    lsBooks.add(new Ls12Book(id++,
                            hashAuthor,
                            Integer.parseInt(matcher.group(2)),
                            matcher.group(3)
                    ));
                }
            }

            res = true;

        } catch (IOException e) {
            println("err:\n" + e.getMessage());
        }

        return res;
    }

    private static void main() {
        println(COMN_DELIMETER + "main");
        println("Использование книжной библиотеки");

        if (!loadBooks()) {
            return;
        }

        println("\tКоличество книг в библиотеке: " + lsBooks.size());
        println("\tКоличество авторов: " + hashMap.keySet().size());

        println("\n\tРаспределение книг по авторам");
        for (var item : hashMap.entrySet()) {
            var ls12AuthorGr = item.getValue();

            var sNum = ls12AuthorGr.getCountAuthor() > 1 ? " книги" : " книга";
            var strPrint = String.format("%20s %-2d%s",
                    ls12AuthorGr.getLs12Author().toString()
                    , ls12AuthorGr.getCountAuthor()
                    , sNum);

            println(strPrint);
        }

        println("\nКниги Льва Толстого");
        var lsAuthor = new Ls12Author("Лев", "Толстой");
        var hashKey = lsAuthor.hashCode();

        if (hashMap.containsKey(hashKey)) {
            for (var item : lsBooks) {
                if (item.getAuthor() == hashKey) {
                    println("\t" + item.toString());
                }
            }
        } else {
            println("Нет книг или ошибка ввода автора");
        }
    }

    public static void runAllTask() {
        println("********* Домашнее задание 12 *********");

        main();
    }
}
