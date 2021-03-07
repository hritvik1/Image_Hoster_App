package com.imagehoster.ImageHosterApp.controller;

import java.util.List;

import com.imagehoster.ImageHosterApp.model.Image;
import com.imagehoster.ImageHosterApp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        // Call getAllImages() method in ImageService class to get the list of all images
        // Add the list of images in the model with the key as "images"
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images", images);
        return "index";
    }
}