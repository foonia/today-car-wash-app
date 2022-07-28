package com.example.nenne.api.Service;

import com.example.nenne.api.Dao.ImageVO;
import com.example.nenne.api.Mapper.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {

    @Value("${file.path}")
    private String fileRealPath;
    private final ImageRepository imageRepository;

    public String SaveImage(String name, MultipartFile file) throws IOException {

        String savedName = null;

        if (file != null) {
            try {
                String originFilename = Objects.requireNonNull(file.getOriginalFilename()).replaceAll(" ", "");
                String formatName = originFilename.substring(originFilename.lastIndexOf(".") + 1).toLowerCase();
                String[] supportFormat = {"bmp", "jpg", "jpeg", "png"};
                if (!Arrays.asList(supportFormat).contains(formatName)) {
                    throw new IllegalArgumentException("지원하지 않는 format 입니다.");
                }
                String origName = file.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                String extension = origName.substring(origName.lastIndexOf("."));
                savedName = name + "_" + uuid + extension;
                String savedPath = fileRealPath + "/" + name;
                String saveName = name + "_" + uuid + originFilename;

                ImageVO imageVO = ImageVO.builder()
                        .mimetype(file.getContentType())
                        .name(name)
                        .original_name(file.getOriginalFilename())
                        .saved_name(savedName)
                        .saved_path(savedPath)
                        .bytes(file.getBytes())
                        .created(String.valueOf(LocalDateTime.now()))
                        .build();

                ImageVO savedImage = imageRepository.save(imageVO);

                if (!new java.io.File(savedPath).exists()) {
                    try {
                        new java.io.File(savedPath).mkdir();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("디렉토리 생성 실패");
                    }
                }

                String filePath = savedPath + "/" + saveName;

                resizeImageFile(file, filePath, formatName);

            } catch (Exception e) {
                throw new IllegalArgumentException("지원하지 않는 확장자입니다.");
            }
        }

        return savedName;
    }

    private void resizeImageFile(MultipartFile files, String filePath, String formatName) throws Exception {
        // 이미지 읽어 오기
        BufferedImage inputImage = ImageIO.read(files.getInputStream());
        // 이미지 세로 가로 측정
        int originWidth = inputImage.getWidth();
        int originHeight = inputImage.getHeight();
        // 변경할 가로 길이
        int newWidth = 500;

        if (originWidth > newWidth) {

            int newHeight = (originHeight * newWidth) / originWidth;

            Image resizeImage = inputImage.getScaledInstance(newWidth, newHeight, Image.SCALE_FAST);
            BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = newImage.getGraphics();
            graphics.drawImage(resizeImage, 0, 0, null);
            graphics.dispose();

            File newFile = new File(filePath);
            ImageIO.write(newImage, formatName, newFile);
        } else {
            files.transferTo(new File(filePath));
        }
    }
}
