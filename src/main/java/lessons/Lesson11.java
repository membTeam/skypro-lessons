package lessons;

import devlInterface.IRunLesson;
import lessons.modelForLesson.Ls11Author;
import lessons.modelForLesson.Ls11Book;

import java.util.ArrayList;
import java.util.HashMap;

import static devlAPI.APIprintService.*;

public class Lesson11 implements IRunLesson {
    /* Задание
        класс Book, который содержит в себе данные о
            названии, авторе, год публикации книги.
            Типы полей должны быть
                String, Author (его мы создадим в п. 2) int.
     */


    private static HashMap<String, Ls11Author> hashMap;
    private static ArrayList<Ls11Book> lsBooks;

    private record recInputData(String firstName, String lastName, int year, String bookName){};

    static {

        hashMap = new HashMap<String, Ls11Author>();
        lsBooks = new ArrayList<>();

        var lsRecInputData = new recInputData[]{
                new recInputData("Лев", "Толстой", 1863, "Война и мир" ),
                new recInputData("Владимир","Набоков", 1955, "Лолита"),
                new recInputData("Ральф", "Эллисон", 1896, "Человек-невидимка") ,
                new recInputData("Джейн","Остен", 1797, "Гордость и предубеждение" ),
                new recInputData("Джейн","Остен", 1815, "Эмма" ),
                new recInputData("Уильям", "Дюбуа", 1903, "Души черного народа"),
                new recInputData("Лев", "Толстой", 1877, "Анна Каренина"),
                new recInputData("Лев", "Толстой", 1936, "Роман о времени Петра I")
        };

        int keyId = 1;
        for(var item : lsRecInputData){

            Ls11Author author = null;
            var keyHash = Ls11Author.creatHashKey(item.firstName, item.lastName);

            if (hashMap.containsKey(keyHash)){
                author = hashMap.get(keyHash);
            } else {
                author = new Ls11Author(item.firstName, item.lastName);
                hashMap.put(keyHash, author);
            }

            lsBooks.add(
                    new Ls11Book(keyId++, author, item.year, item.bookName)
            );
        }
    }

    private static void main(){
        println(COMN_DELIMETER + "main");
        println("Использование книжной библиотеки");

        println("\tКол-во книг: " + lsBooks.size());
        println("\tКол-во авторов:" + (hashMap.keySet().size() ));

        println("");
        println("Изменение даты выпуска книги");
        var nameBook = "Война и мир";
        var bookItem = Ls11Book.getItemBook(lsBooks, nameBook);

        if (bookItem == null){
            println(  nameBook + " не найдена");
        } else {
            println("\t" + bookItem.toString());
            bookItem.setYear(bookItem.getYear() + 1);

            println("\t" + "После изм. " + bookItem.toString());
        }

        println("");
        println("ВСЕ книги автора Льва Толстого");
        var keyHash = Ls11Author.creatHashKey("Лев", "Толстой");

        for (var item : lsBooks){
            if (item.getAuthor().getId().equals(keyHash)){
                println("\t" + item.getYear() + "г. " + item.getBookName());
            }
        }
    }

    public static void runAllTask(){
        println("********* Домашнее задание 11 *********");

        main();
    }

}
