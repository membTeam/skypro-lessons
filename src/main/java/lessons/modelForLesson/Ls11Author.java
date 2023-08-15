package lessons.modelForLesson;

/**
 * Модель для Lesson11
 */
public class Ls11Author {

    private String id;
    private String firstName;
    private String lastName;

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    public static String creatHashKey(String firstName, String lastName){
        return  (firstName.trim() + lastName.trim()).toLowerCase();
    }

    public Ls11Author(String firstName, String lastName){

        this.id = (firstName.trim() + lastName.trim()).toLowerCase();

        this.firstName = firstName;
        this.lastName = lastName;
    }

    // --------------------------------

    public String getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
