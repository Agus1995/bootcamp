package com.enigma.koperasi.controller;

import com.enigma.koperasi.entity.KoperasiBulananEntity;
import com.enigma.koperasi.repository.KoperasiBarangRepository;
import com.enigma.koperasi.repository.KoperasiBulananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(path = "/bulan")
public class KoperasiBulananController {
    @Autowired
    KoperasiBulananRepository koperasiBulananRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<KoperasiBulananEntity> getList() throws Exception{
        List<KoperasiBulananEntity> listBulan = koperasiBulananRepository.findAll();
        return listBulan;
    }
}
