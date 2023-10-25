package com.api.book.springbootrestbook.FileHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // Image Uplaoding using static path
   // public final String UPLOAD_DIR = "E:\\Programs\\SpringBoot\\SpringBootRESTAPIBook\\springbootrestbook\\src\\main\\resources\\static\\Image";

    // Image Uploading dynamic path
    public final String UPLOAD_DIR = new
    ClassPathResource("/static/Image/").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;

        try {

            InputStream inputStream = multipartFile.getInputStream();
            byte data[] = new byte[inputStream.available()];
            inputStream.read(data);

            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "\\" +
                    multipartFile.getOriginalFilename());
            fileOutputStream.flush();
            fileOutputStream.close();

            // Files.copy(multipartFile.getInputStream(),
            // Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
            // StandardCopyOption.REPLACE_EXISTING);

            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }
}
