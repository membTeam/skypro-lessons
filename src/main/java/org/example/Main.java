package org.example;

import devlAPI.RunLesson;
import static devlAPI.APIprintService.*;

public class Main {
    public static void main(String[] args) {

        println("\tДомашние задания Sky-pro");

        try{
            var runTask = RunLesson.runTask();
        } catch (Exception ex){
            println("err:\n" + ex.getMessage());
        }

    }
}