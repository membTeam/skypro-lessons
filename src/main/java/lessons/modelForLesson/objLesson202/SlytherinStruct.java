package lessons.modelForLesson.objLesson202;

public class SlytherinStruct extends Slytherin {
    // ,  находчивость и жажда власти

    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int lustForPower;


    public static SlytherinStruct createFacultetStructByArrRecord(RecordParams[] arrRecordParams) throws Exception {
        try {
            return new SlytherinStruct(
                    ComnFacultet.getValueFromArrRecordParams("cunning", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("determination", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("ambition", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("resourcefulness", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("lustForPower", arrRecordParams)
            );
        } catch (Exception ex){
            throw new Exception("SlytherinStruct.createObjStructByArrRecord\nerr: " +  ex.getMessage());
        }
    }

    public SlytherinStruct(int cunning, int determination,
                           int ambition, int resourcefulness,
                           int lustForPower) {
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.lustForPower = lustForPower;
    }

    @Override
    public String toString() {
        return '(' + this.getNameFacultet() + ')' +
                " показатели на уровне факультета" +
                "\n\tхитрость:" + cunning +
                ", решительность:" + determination +
                "\n\tамбициозность:" + ambition +
                ", находчивость:" + resourcefulness +
                ", жаждаВласти:" + lustForPower
                ;
    }

    @Override
    public int getSumProperty() {
        return cunning + determination + ambition + resourcefulness + lustForPower;
    }

    public int getCunning() {
        return cunning;
    }

    public void setCunning(int cunning) {
        this.cunning = cunning;
    }

    public int getDetermination() {
        return determination;
    }

    public void setDetermination(int determination) {
        this.determination = determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public void setAmbition(int ambition) {
        this.ambition = ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(int resourcefulness) {
        this.resourcefulness = resourcefulness;
    }

    public int getLustForPower() {
        return lustForPower;
    }

    public void setLustForPower(int lustForPower) {
        this.lustForPower = lustForPower;
    }
}
