package com.SwagLabs.Utilites.Helpers;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {

    public static final String Allure_Result_Path = "test-outputs/allure-results";

    public static void attachLogsToAllureReport(){
        try {
            File logFile = FilesUtils.getLastFile(LogsUtils.logPath);
            if(!logFile.exists()){
                LogsUtils.warn("Log file does not exist: "+logFile);
                return;
            }
            Allure.addAttachment("Logs", Files.readString(Path.of(logFile.getPath())));
            LogsUtils.info("Logs attached to allure report");
        }catch (Exception e){
            LogsUtils.error("Failed to attach logs to allure report: "+e.getMessage());
        }
    }
}
