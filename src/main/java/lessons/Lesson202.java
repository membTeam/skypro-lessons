package lessons;

import lessons.modelForLesson.objLesson202.*;

import static devlAPI.APIprintService.println;

import java.util.*;

public class Lesson202 {
    private final static Random random;
    private final static University university;

    private static int getRandomInt() {
        int start = 10, end = 100;

        return random.nextInt(end - start) + start - 1;
    }

    private static final HashMap<String, String[]> hashMapStudents;

    static {
        random = new Random();
        university = new University();

        hashMapStudents = new HashMap<>();
        hashMapStudents.put(Slytherin.class.getSimpleName(), new String[]{"Драко Малфой", "Грэхэм Монтегю", "Грегори Гойл"});
        hashMapStudents.put(Pufendies.class.getSimpleName(), new String[]{"Захария Смит", "Седрик Диггори", "Джастин ФинчФлетчли"});
        hashMapStudents.put(Gryffindor.class.getSimpleName(), new String[]{"Гарри Поттер", "Гермиона Грейнджер", "Рон Уизли"});
        hashMapStudents.put(Cogtevran.class.getSimpleName(), new String[]{"Чжоу Чанг", "Падма Патил", "Маркус Белби"});
    }

    private static void initListOfStudents(EFaculties eFaculties) {

        var facultet = university.getFacultetByEnum(eFaculties);

        var arrParameterFacultet = ComnFacultet.getArrParameterFaculter(eFaculties);
        var arrNameStudent = hashMapStudents.get(eFaculties.getClassName());

        var lenArrParameterFacultet = arrParameterFacultet.length;

        for (var nameStudent : arrNameStudent) {
            var arrRecordParams = new RecordParams[lenArrParameterFacultet];

            var index = 0;
            for (var parameterFacultet : arrParameterFacultet) {
                arrRecordParams[index++] = new RecordParams(parameterFacultet, getRandomInt());
            }

            try {
                facultet.addStudent(eFaculties, nameStudent, arrRecordParams);
            } catch (Exception ex) {
                println("err from initListOfStudents:\n" + ex.getMessage());
                return;
            }
        }
    }

    private static void printDataForFacultet(EFaculties eFacultet) {

        var facultet = university.getFacultetByEnum(eFacultet);

        var listStudent = facultet.getListStudent();
        if (listStudent.size() > 0) {

            var nameFaculter = facultet.getNameFacultet();
            println("\nФакультет " + nameFaculter + ':' +
                    " кол-во студентов: " + listStudent.size());

            for (var student : listStudent) {
                println("\tname:" + student.getName() + " суммаБаллов:" + student.getSumAllProperty());
            }

            println("Студент с максимальными показателями");
            var studentMaxVal = facultet.getstudentWithMaxOfPerformance();
            println('\t' + studentMaxVal.toString());

            println("Студент с худшими показателями");
            var studentMinVal = facultet.getstudentWithMinOfPerformance();
            println('\t' + studentMinVal.toString());
        }

    }

    public static void runAllTask() {
        println("********* Домашнее задание 202 *********");

        initListOfStudents(EFaculties.COGTEVRAN);
        printDataForFacultet(EFaculties.COGTEVRAN);

        initListOfStudents(EFaculties.GRYFFINDOR);
        printDataForFacultet(EFaculties.GRYFFINDOR);

        initListOfStudents(EFaculties.PUFENDIES);
        printDataForFacultet(EFaculties.PUFENDIES);

        initListOfStudents(EFaculties.SLYTHERIN);
        printDataForFacultet(EFaculties.SLYTHERIN);
    }
}
