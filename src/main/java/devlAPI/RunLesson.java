package devlAPI;

import devlRecord.RecordResProc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunLesson {

    public static RecordResProc runTask()
            throws ClassNotFoundException,
                    NoSuchMethodException,
                    InvocationTargetException,
                    IllegalAccessException {

        var confData = new ConfigData();
        if ( !confData.isRunLesson() ){
            return APIerror.getRecordResProc("Отмена запуска программ из файла textData/config.txt");
        }

        Class<?> classTask = Class.forName ("lessons." + confData.getLesson());
        Method taskMethod = classTask.getMethod("runAllTask");
        taskMethod.invoke(null);

        return APIerror.getResProcOk();

    }

}
