package lessons.modelForLesson;

import java.util.Objects;

public class Ls12Author {
    private String firstName;
    private String lastName;

    public Ls12Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // ----------------- get & set
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


    // -------------- Override
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Ls12Author that = (Ls12Author) obj;

        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toUpperCase(), lastName.toUpperCase());
    }
}
