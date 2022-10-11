package com.homework.homework_school.service;

import com.homework.homework_school.model.Avatar;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.AvatarRepository;
import com.homework.homework_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;

    private final StudentRepository studentRepository;

    private Avatar avatar;

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    public AvatarService(AvatarRepository avatarRepository, StudentRepository studentRepository) {
        this.avatarRepository = avatarRepository;
        this.studentRepository = studentRepository;
    }

    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentRepository.findById(studentId).orElseThrow();
//        if(this.avatar == null) {
//            return;
//        }
        Path filePath = Path.of(avatarsDir, studentId + getExtensions(avatarFile.getOriginalFilename()));
        System.out.println(filePath.getParent());
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
                ) {
          bis.transferTo(bos);
        } catch (IOException e) {
            Avatar avatarImage = avatarRepository.findByStudentId(studentId).orElseGet(Avatar::new);
            avatarImage.setStudent(student);
            avatarImage.setFilePath(filePath.toString());
            avatarImage.setFileSize(avatarFile.getSize());
            avatarImage.setMediaType(avatarFile.getContentType());
            avatarImage.setData(avatarFile.getBytes());
            avatarRepository.save(avatar);

        }

        }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf((".")));
    }


}
