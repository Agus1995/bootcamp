package com.enigma.koperasi.controller;


import com.enigma.koperasi.entity.KoperasiBarangEntity;
import com.enigma.koperasi.repository.KoperasiBarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(path = "/barang")
public class KoperasiBarangController {
    @Autowired
    KoperasiBarangRepository koperasiBarangRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<KoperasiBarangEntity> getList() throws Exception{
        List<KoperasiBarangEntity> listBarang = koperasiBarangRepository.findAll();
        return listBarang;
    }

    @PostMapping("/add")
    public KoperasiBarangEntity addBarang(@RequestBody KoperasiBarangEntity barang){
        return koperasiBarangRepository.save(barang);
    }

    @PutMapping("/update/{id}")
    KoperasiBarangEntity update(@RequestBody KoperasiBarangEntity barang, @PathVariable Integer id) {

        return koperasiBarangRepository.findById(id)
                .map(ent -> {
                    ent.setNama_barang(barang.getNama_barang());
                    ent.setHarga(barang.getHarga());
                    return koperasiBarangRepository.save(ent);
                })
                .orElseGet(() -> {
                    barang.setId(id);
                    return koperasiBarangRepository.save(barang);
                });
    }
}
