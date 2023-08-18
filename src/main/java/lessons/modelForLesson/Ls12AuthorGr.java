package lessons.modelForLesson;

public class Ls12AuthorGr {
    private int countAuthor;
    private Ls12Author ls12Author;

    public Ls12AuthorGr(Ls12Author ls12Author){
        countAuthor = 1;
        this.ls12Author = ls12Author;
    }

    // -------------------- get & set

    public Ls12Author getLs12Author() {
        return ls12Author;
    }

    public int getCountAuthor() {
        return countAuthor;
    }

    public void setCountAuthor() {
        this.countAuthor++;
    }
}
