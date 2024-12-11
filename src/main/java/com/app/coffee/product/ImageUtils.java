package com.app.coffee.product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
import java.io.File;


public class ImageUtils {

    public static boolean isFileNameExists(String directory, String fileName) {
        File file = new File(directory, fileName);
        return file.exists();
    }

    public static String generateUniqueFileName(String directory, String originalFileName) {
        String fileName = originalFileName;
        String fileExtension = "";
        int dotIndex = originalFileName.lastIndexOf('.');

        if (dotIndex != -1) {
            fileName = originalFileName.substring(0, dotIndex);
            fileExtension = originalFileName.substring(dotIndex);
        }

        int counter = 1;
        String newFileName = fileName + fileExtension;

        while (isFileNameExists(directory, newFileName)) {
            newFileName = fileName + "_" + counter + fileExtension;
            counter++;
        }

        return newFileName;
    }

}
