package lessons.modelForLesson.objLesson202;

public class CogtevranStruct extends Cogtevran {
    private int smart;
    private int mudras;
    private int witty;
    private int fullOfCreativity;

    public CogtevranStruct(int smart, int mudras, int witty, int fullOfCreativity) {
        this.smart = smart;
        this.mudras = mudras;
        this.witty = witty;
        this.fullOfCreativity = fullOfCreativity;
    }

    public static CogtevranStruct createFacultetStructByArrRecord(RecordParams[] arrRecordParams) throws Exception {
        try {
            return new CogtevranStruct(
                    ComnFacultet.getValueFromArrRecordParams("smart", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("mudras", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("witty", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("fullOfCreativity", arrRecordParams)
            );
        } catch(Exception ex){
                throw new Exception("CogtevranStruct.createObjStructByArrRecord\nerr: " + ex.getMessage());
            }
        }

    // ------------ get and set
    @Override
    public String toString() {
        return '(' + this.getNameFacultet() + ')' +
                " показатели на уровне факультета" +
                "\n\tУмственные способности:" + smart +
                ", Мудрость:" + mudras +
                "\n\tОстроумность:" + witty +
                ", Творчество:" + fullOfCreativity;

    }

    @Override
    public int getSumProperty() {
        return smart + mudras + witty + fullOfCreativity;
    }

    public int getSmart() {
        return smart;
    }

    public void setSmart(int smart) {
        this.smart = smart;
    }

    public int getMudras() {
        return mudras;
    }

    public void setMudras(int mudras) {
        this.mudras = mudras;
    }

    public int getWitty() {
        return witty;
    }

    public void setWitty(int witty) {
        this.witty = witty;
    }

    public int getFullOfCreativity() {
        return fullOfCreativity;
    }

    public void setFullOfCreativity(int fullOfCreativity) {
        this.fullOfCreativity = fullOfCreativity;
    }
}
