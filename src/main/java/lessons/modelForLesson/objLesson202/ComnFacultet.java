package lessons.modelForLesson.objLesson202;

import java.util.ArrayList;
import java.util.List;

import static devlAPI.APIprintService.println;

public class ComnFacultet {

    private interface ISettingParams {
        ComnFacultet setParams(RecordParams[] arrRecordParams) throws Exception;
    }
    private final String nameFacultet;
    private final List<Student> listStudent;

    public ComnFacultet(String nameFacultet){
        this.nameFacultet = nameFacultet;
        this.listStudent = new ArrayList<>();
    }

    public static String[] getArrParameterFaculter(EFaculties eFaculties){
        String[] arrResult;
        arrResult = switch (eFaculties){
            case SLYTHERIN -> new String[]{"magi", "distMagi", "cunning", "determination", "ambition", "resourcefulness", "lustForPower"};
            case COGTEVRAN -> new String[]{"magi", "distMagi", "smart", "mudras", "witty", "fullOfCreativity"};
            case GRYFFINDOR -> new String[]{"magi", "distMagi", "nobility", "honor", "bravery"};
            case PUFENDIES -> new String[]{"magi", "distMagi", "hardworking", "loyaltyToIdeals", "honesty"};
        };

        return arrResult;
    }

    private static ISettingParams getSettingParamsForFacultetByEnum(EFaculties eFaculties){
        ISettingParams settingParams;
        settingParams = switch (eFaculties){
            case SLYTHERIN -> SlytherinStruct::createFacultetStructByArrRecord;
            case COGTEVRAN -> CogtevranStruct::createFacultetStructByArrRecord;
            case GRYFFINDOR -> GryffindorStruct::createFacultetStructByArrRecord;
            case PUFENDIES -> PufendiesStruct::createFacultetStructByArrRecord;
        };

        return settingParams;
    }

    public static int getValueFromArrRecordParams(String name,
                                           RecordParams[] arrRecordParams) throws Exception {
        var result = -1;

        for(var item : arrRecordParams){
            if (item.name().equalsIgnoreCase(name)){
                result = item.value();
                break;
            }
        }

        if (result < 0)
            throw new Exception(String.format("Параметр (%s) не найден", name));

        return result;
    }

    public void addStudent(EFaculties eFaculties, String nameStudent, RecordParams[] arrRecordParams) throws Exception{

        var magi = getValueFromArrRecordParams("magi", arrRecordParams);
        var distMagi = getValueFromArrRecordParams("distMagi", arrRecordParams);

        var settingParamsForFacultet = getSettingParamsForFacultetByEnum(eFaculties);

        Student student;
        try {
            var structFacultet = settingParamsForFacultet.setParams(arrRecordParams);
            student = new Student(structFacultet, nameStudent, magi, distMagi);
        } catch (Exception ex){
            println("err: " + ex.getMessage());
            return;
        }

        getListStudent().add(student);
    }

    public Student getstudentWithMaxOfPerformance(){
        Student student = null;
        var sumValues = 0;

        for (var item : getListStudent()){
            if (item.getSumAllProperty() > sumValues){
                sumValues = item.getSumAllProperty();
                student = item;
            }
        }

        return student;
    }

    public Student getstudentWithMinOfPerformance(){
        Student student = null;
        var sumValues = Integer.MAX_VALUE;

        for (var item : getListStudent()){
            if (item.getSumAllProperty() < sumValues){
                sumValues = item.getSumAllProperty();
                student = item;
            }
        }

        return student;
    }

    // ---------------------------------
    public String getNameFacultet() {
        return nameFacultet;
    }

    public List<Student> getListStudent() {
        return listStudent;
    }

    public int getSumProperty(){ return 0;}
}
