package lessons.modelForLesson.objLesson202;

public enum EFaculties {
    COGTEVRAN(Cogtevran.class.getSimpleName()),
    SLYTHERIN(Slytherin.class.getSimpleName()),
    GRYFFINDOR(Gryffindor.class.getSimpleName()),
    PUFENDIES(Pufendies.class.getSimpleName());

    private String className;

    EFaculties(String name) {
        className = name;
    }

    public String getClassName() {
        return className;
    }

}
