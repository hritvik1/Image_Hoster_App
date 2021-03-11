package com.hritvik.ImageHosterApp.controller;

import com.hritvik.ImageHosterApp.model.Image;
import com.hritvik.ImageHosterApp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/")
    public String Home(Model model)
    {
        List<Image> images = imageService.getAllImages();
        model.addAttribute("images", images);
        return "index";
    }

    @RequestMapping(value = "/User_Images")
    public String temp() {
        return "User_Images";
    }
}