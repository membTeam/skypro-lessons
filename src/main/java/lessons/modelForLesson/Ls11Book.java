package lessons.modelForLesson;

import java.util.ArrayList;

/**
 * Модель для Lesson11
 */
public class Ls11Book {

    private int id;
    private Ls11Author author;
    private int year;
    private String bookName;

    public Ls11Book(int id, Ls11Author author, int year, String bookName){
        this.id = id;
        this.author = author;
        this.year = year;
        this.bookName = bookName;
    }


    // --------------------------------

    public static Ls11Book getItemBook(ArrayList<Ls11Book> lsBooks, String nameBook){
        Ls11Book res = null;
        for (var item : lsBooks){
            if (item.getBookName().equals(nameBook)){
                res = item;
                break;
            }
        }

        return res;
    }

    @Override
    public String toString(){
        var res = String.format("%10s годИзд:%d %s", author.toString(), year, bookName);
        return res;
    }

    public int getId(){
        return id;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }

    public Ls11Author getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }
}
