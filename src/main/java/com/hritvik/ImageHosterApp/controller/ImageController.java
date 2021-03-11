package com.hritvik.ImageHosterApp.controller;

import java.util.Date;
import com.hritvik.ImageHosterApp.model.Image;
import com.hritvik.ImageHosterApp.model.User;
import com.hritvik.ImageHosterApp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.GET, value = "upload_update/upload")
    public String uploadImg() {
        return "upload_update/upload";
    }

    @RequestMapping(method = RequestMethod.POST, value = "upload_update/upload")
    public String uploadNewImage(Image newImage, HttpSession session) {
        User user = (User) session.getAttribute("LoggedUser");
        newImage.setUser(user);
        newImage.setDate(new Date());
        imageService.uploadImage(newImage);
        return "redirect:/";
    }

    @RequestMapping(value = "/upload_update/update")
    public String updateImage(Model model) {
        return "upload_update/update";
    }
}