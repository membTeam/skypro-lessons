package lessons.modelForLesson.objLesson202;

public class University {
    private String name;
    private Cogtevran cogtevran;
    private Gryffindor gryffindor;
    private Pufendies pufendies;
    private Slytherin slytherin;


    public University() {
        this.name = "Хогвартс";

        cogtevran = new Cogtevran();
        gryffindor = new Gryffindor();
        pufendies = new Pufendies();
        slytherin = new Slytherin();
    }

    // --------------- get and set
    public ComnFacultet getFacultetByEnum(EFaculties eFaculties){
        return switch (eFaculties){
            case COGTEVRAN -> cogtevran;
            case SLYTHERIN -> slytherin;
            case GRYFFINDOR -> gryffindor;
            case PUFENDIES -> pufendies;
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cogtevran getCogtevran() {
        return cogtevran;
    }

    public void setCogtevran(CogtevranStruct cogtevran) {
        this.cogtevran = cogtevran;
    }

    public Gryffindor getGryffindor() {
        return gryffindor;
    }

    public void setGryffindor(Gryffindor gryffindor) {
        this.gryffindor = gryffindor;
    }

    public Pufendies getPufendies() {
        return pufendies;
    }

    public void setPufendies(Pufendies pufendies) {
        this.pufendies = pufendies;
    }

    public Slytherin getSlytherin() {
        return slytherin;
    }

    public void setSlytherin(Slytherin slytherin) {
        this.slytherin = slytherin;
    }
}
