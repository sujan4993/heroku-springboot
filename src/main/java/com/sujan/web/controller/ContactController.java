/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.controller;

import com.sujan.web.entity.Contact;
import com.sujan.web.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    
    @GetMapping()
    public String index() {
        return "contact/index";
    }
    
    @PostMapping
    @ResponseBody
    public String save(@ModelAttribute(value = "Contact")Contact contact){
        String data = "<h1>Your Details</h1>";
        
        data +="<br/>Name:" +contact.getName();
        data +="<br/>Email:" +contact.getEmail();
        data +="<br/>Subject:" +contact.getSubject();
        data +="<br/>Message:" +contact.getBody();
        
        return data;
    }
    
    @GetMapping(value = "/admin")
    public String admin(Model model){
        model.addAttribute("contacts",contactRepository.findAll());
        return "contact/admin/index";
    }

}
