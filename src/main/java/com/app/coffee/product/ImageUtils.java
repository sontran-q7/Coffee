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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageUtils {

    // Phương thức kiểm tra tên tệp đã tồn tại hay chưa
    public static boolean isFileNameExists(String directory, String fileName) {
        File file = new File(directory, fileName);
        return file.exists();
    }

    // Phương thức để tạo tên tệp mới nếu tên bị trùng
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

    // Phương thức lưu hình ảnh với tên mới nếu bị trùng
//    public static void saveImageWithUniqueName(String sourceFilePath, String targetDirectory) throws IOException {
//        Path sourcePath = Paths.get(sourceFilePath);
//        String fileName = sourcePath.getFileName().toString();
//        String uniqueFileName = generateUniqueFileName(targetDirectory, fileName);
//        Path targetPath = Paths.get(targetDirectory, uniqueFileName);
//
//        Files.copy(sourcePath, targetPath);
//        System.out.println("Image saved as: " + targetPath.toString());
//    }
}
