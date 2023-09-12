package lessons.modelForLesson.objLesson202;

public class PufendiesStruct extends Pufendies{
    private int hardworking;
    private int loyaltyToIdeals;
    private int honesty;

    public static PufendiesStruct createFacultetStructByArrRecord(RecordParams[] arrRecordParams) throws Exception{
        try {
            return new PufendiesStruct(
                    ComnFacultet.getValueFromArrRecordParams("hardworking", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("loyaltyToIdeals", arrRecordParams),
                    ComnFacultet.getValueFromArrRecordParams("honesty", arrRecordParams)
            );
        } catch (Exception ex){
            throw new Exception("PufendiesStruct.createObjStructByArrRecord\nerr: " + ex.getMessage());
        }
    }

    public PufendiesStruct(int hardworking, int loyaltyToIdeals, int honesty) {
        this.hardworking = hardworking;
        this.loyaltyToIdeals = loyaltyToIdeals;
        this.honesty = honesty;
    }

    // ------------ get and set
    @Override
    public String toString() {
        return  '(' + this.getNameFacultet() + ')' +
                " показатели на уровне факультета" +
                "\n\tтрудолюбие:" + hardworking +
                ", верность идеалам:" + loyaltyToIdeals +
                ", честность:" + honesty;
    }

    @Override
    public int getSumProperty(){
        return hardworking + loyaltyToIdeals + honesty;
    }

    public int getHardworking() {
        return hardworking;
    }

    public void setHardworking(int hardworking) {
        this.hardworking = hardworking;
    }

    public int getLoyaltyToIdeals() {
        return loyaltyToIdeals;
    }

    public void setLoyaltyToIdeals(int loyaltyToIdeals) {
        this.loyaltyToIdeals = loyaltyToIdeals;
    }

    public int getHonesty() {
        return honesty;
    }

    public void setHonesty(int honesty) {
        this.honesty = honesty;
    }
}
