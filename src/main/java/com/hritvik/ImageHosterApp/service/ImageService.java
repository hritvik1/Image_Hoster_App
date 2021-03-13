package com.hritvik.ImageHosterApp.service;

import com.hritvik.ImageHosterApp.model.Image;
import com.hritvik.ImageHosterApp.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void uploadImage(Image newImage, MultipartFile file) {
        try {
            newImage.setImageFile(convertImgToBase64(file));
            imageRepository.createImage(newImage);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private String convertImgToBase64(MultipartFile file) throws IOException {
        return Base64.getEncoder().encodeToString(file.getBytes());
    }

    public List<Image> getAllImages() {
        return imageRepository.getAllImages();
    }

    public List<Image> getUserImages(Integer userId) {
        return imageRepository.getUserImages(userId);
    }

    public Image getImgData(Integer imageId) {
        return imageRepository.getImgData(imageId);
    }

    public void updateImgData(Image updatedImgData, MultipartFile ufile) {
        try {
            updatedImgData.setImageFile(convertImgToBase64(ufile));
            imageRepository.updateImgData(updatedImgData);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}