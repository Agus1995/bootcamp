package com.example.demo.controller;

import com.example.demo.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahasiswaController {

    private MahasiswaService mahasiswaservice;
    @Autowired
    public void setMahasiswaservice(MahasiswaService mahasiswaservice) {
        this.mahasiswaservice = mahasiswaservice;
    }

    @RequestMapping("/mahasiswa")
    public String MahasiswaList(Model model){

        model.addAttribute("mahasiswa", mahasiswaservice.listMahasiswa());
        return "mahasiswa";
    }
}
