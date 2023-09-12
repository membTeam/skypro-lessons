package lessons.modelForLesson.objLesson202;

public class GryffindorStruct extends Gryffindor {

    // благородство, честь и храбрость.
    private int nobility;
    private int honor;
    private int bravery;

    public static GryffindorStruct createFacultetStructByArrRecord(RecordParams[] arrRecordParams) throws Exception{
        try {
            return new GryffindorStruct(
                    ComnFacultet.getValueFromArrRecordParams("nobility", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("honor", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("bravery", arrRecordParams)
            );
        } catch(Exception ex){
            throw new Exception("GryffindorStruct.createObjStructByArrRecord\nerr: " + ex.getMessage());
        }

    }

    public GryffindorStruct(int nobility, int honor, int bravery) {
        this.nobility = nobility;
        this.honor = honor;
        this.bravery = bravery;
    }

    // ------------ get and set
    @Override
    public String toString() {

        return  '(' + this.getNameFacultet() + ')' +
                " показатели на уровне факультета" +
                "\n\tблагородство:" + nobility +
                ", моральные качества:" + honor +
                ", храбрость:" + bravery;

    }

    @Override
    public int getSumProperty(){
        return nobility + honor + bravery;
    }

    public int getNobility() {
        return nobility;
    }

    public void setNobility(int nobility) {
        this.nobility = nobility;
    }

    public int getHonor() {
        return honor;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }

    public int getBravery() {
        return bravery;
    }

    public void setBravery(int bravery) {
        this.bravery = bravery;
    }
}
