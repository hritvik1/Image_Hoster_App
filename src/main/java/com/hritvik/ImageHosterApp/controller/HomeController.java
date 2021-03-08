package com.hritvik.ImageHosterApp.controller;

import java.util.List;

import com.hritvik.ImageHosterApp.model.Image;
import com.hritvik.ImageHosterApp.service.ImageService;
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

    @RequestMapping(value = "/login_signup/login")
    public String login(Model model) {
        return "login_signup/login";
    }

    @RequestMapping(value = "/login_signup/signup")
    public String signup(Model model) {
        return "login_signup/signup";
    }

    @RequestMapping(value = "/upload_update/upload")
    public String upload(Model model) {
        return "upload_update/upload";
    }

    @RequestMapping(value = "/upload_update/update")
    public String update(Model model) {
        return "upload_update/update";
    }
}