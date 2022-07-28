package com.example.nenne.api.Controller;

import com.example.nenne.api.ApiException.ApiException;
import com.example.nenne.api.ApiException.ExceptionEnum;
import com.example.nenne.api.Entity.ImageResponse;
import com.example.nenne.api.Service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Value("${file.path}")
    private String fileRealPath;

    private final ImageService imageService;

    @ResponseBody
    @PostMapping(value = "/upload")
    public ResponseEntity<ImageResponse> UploadImage(@RequestParam("name") String name, @RequestParam("files") List<MultipartFile> files) throws IOException{
        List<String> savename = new ArrayList<>();
        ImageResponse imageResponse = new ImageResponse();
        try {
            for (MultipartFile multipartFile : files) {
                savename.add(imageService.SaveImage(name, multipartFile));
            }
        }
        catch (StringIndexOutOfBoundsException e){
            throw new ApiException(ExceptionEnum.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION);
        }
        imageResponse.setCode("200");
        imageResponse.setStatus(HttpStatus.OK);
        imageResponse.setItems(savename);

        return new ResponseEntity<>(imageResponse,OK);
    }

    @GetMapping(value = "/show", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] ShowImage(@RequestParam("name") String name, @RequestParam("filename") String filename) throws IOException{

        String str = fileRealPath + "/" + name + "/" + filename;
        InputStream in = new FileInputStream(str);

        return IOUtils.toByteArray(in);
    }
}
