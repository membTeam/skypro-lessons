package devlAPI;

import devlRecord.RecordResProc;

public class APIerror {

    public static RecordResProc getResProcOk(){
        return new RecordResProc(true, "ok", null);
    }

    public static RecordResProc getRecordResProc(String err){
        return new RecordResProc(false, err, null);
    }

    private static boolean err = false;
    private static String mes;

    /**
     * После считывания сообщения состояние сбрасывается
     * @return
     */
    public static String getMes(){
        String res = mes;
        resetErr();
        return res;
    }
    public static boolean getErr(){
        return  err;
    }

    public static void resetErr(){
        err = false;
        mes = "";
    }

    public static void setError(String mesErr){
        err = true;
        mes = mesErr;
    }

}
