package com.SwagLabs.Utilites.Helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {


    public static void deleteFiles(File dirPath){
        if(dirPath == null || !dirPath.exists()){
            LogsUtils.warn("Directory does not exist "+dirPath);

        }

        File[] filesList = dirPath.listFiles();
        if(filesList == null){
            LogsUtils.warn("Failed to list files in: "+dirPath);
        }

        for (File file : filesList){
            if(file.isDirectory()){
                deleteFiles(file);
            }else {
                try {
                    Files.delete(file.toPath());
                }catch (IOException e){
                    LogsUtils.error("Failed to delete file: "+file);
                }
            }

        }
    }


    public static File getLastFile(String folderPath){
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if(files == null || files.length==0){
            LogsUtils.warn("No files found in directory: "+folderPath);
            return null;
        }

        File lastFile = files[0];
        for (File file : files){
            if(file.lastModified() > lastFile.lastModified()){
                lastFile=file;
            }
        }
        return lastFile;

    }
}
