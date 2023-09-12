package lessons.modelForLesson.objLesson202;

public class Student {
    private String name;
    private int magi;
    private int distMagi;
    private ComnFacultet facultetStruct;

    public Student(ComnFacultet comnFacultet, String name, int magi, int distMagi) {

        this.facultetStruct = comnFacultet;

        this.name = name;
        this.magi = magi;
        this.distMagi = distMagi;
    }

    // --------- get and set
    @Override
    public String toString() {
        return "name:" + name +
                " суммарныйПоказатель:" + getSumAllProperty() +
                "\n\tмагия:" + magi +
                ", дистанция:" + distMagi + "\n\t" +
                getFacultetStructToString();
    }

    private String getFacultetStructToString(){
        return facultetStruct.toString();
    }

    public int getSumAllProperty() {
        return facultetStruct.getSumProperty() + magi + distMagi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagi() {
        return magi;
    }

    public void setMagi(int magi) {
        this.magi = magi;
    }

    public int getDistMagi() {
        return distMagi;
    }

    public void setDistMagi(int distMagi) {
        this.distMagi = distMagi;
    }

    public ComnFacultet getFacultetStruct() {
        return facultetStruct;
    }

}
