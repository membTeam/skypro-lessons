package lessons.modelForLesson;

import java.util.ArrayList;
import java.util.Objects;

public class Ls12Book {
    private int id;
    private int hashAuthor;
    private int year;
    private String bookName;

    public Ls12Book(int id, int author, int year, String bookName){
        this.id = id;
        this.hashAuthor = author;
        this.year = year;
        this.bookName = bookName;
    }


    // --------------------------------

    public static Ls12Book getItemBook(ArrayList<Ls12Book> lsBooks, String nameBook){
        Ls12Book res = null;
        for (var item : lsBooks){
            if (item.getBookName().equalsIgnoreCase(nameBook)){
                res = item;
                break;
            }
        }

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

    public int getAuthor() {
        return hashAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    // ------------------- Override
    @Override
    public String toString(){
        var res = String.format("годИзд:%d %s", year, bookName);
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Ls12Book ls12Book = (Ls12Book) obj;

        return hashAuthor == ls12Book.hashAuthor
                && year == ls12Book.year && Objects.equals(bookName, ls12Book.bookName);
    }

}
