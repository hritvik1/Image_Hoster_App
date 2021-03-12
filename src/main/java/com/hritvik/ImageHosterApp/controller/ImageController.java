package com.hritvik.ImageHosterApp.controller;

import java.util.Date;
import java.util.List;

import com.hritvik.ImageHosterApp.model.Image;
import com.hritvik.ImageHosterApp.model.User;
import com.hritvik.ImageHosterApp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping("/User_Images")
    public String UserImages(Model model, HttpSession session) {
        if(session.getAttribute("LoggedUser") == null) {
            return "redirect:/login_signup/login";
        } else {
            User user = (User) session.getAttribute("LoggedUser");
            List<Image> images = imageService.getUserImages(user.getId());
            model.addAttribute("userImages", images);
            return "User_Images";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "upload_update/upload")
    public String uploadImg(HttpSession session) {
        if(session.getAttribute("LoggedUser") == null) {
            return "redirect:/login_signup/login";
        } else {
            return "upload_update/upload";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "upload_update/upload")
    public String uploadNewImage(@RequestParam("file") MultipartFile file, Image newImage, HttpSession session) {
        User user = (User) session.getAttribute("LoggedUser");
        newImage.setUser(user);
        newImage.setDate(new Date());
        imageService.uploadImage(newImage, file);
        return "redirect:/User_Images";
    }

    @RequestMapping(value = "/upload_update/update")
    public String updateImage(Model model) {
        return "upload_update/update";
    }
}