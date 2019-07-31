package com.enigma.koperasi.controller;


import com.enigma.koperasi.entity.KoperasiAnggotaEntity;
import com.enigma.koperasi.repository.KoperasiAnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(path = "/anggota")
public class KoperasiAnggotaController {
    @Autowired
    KoperasiAnggotaRepository koperasiAnggotaRepopsitory;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<KoperasiAnggotaEntity> getList() throws Exception{
        List<KoperasiAnggotaEntity> listAnggota = koperasiAnggotaRepopsitory.findAll();
        return listAnggota;
    }

    @PostMapping("/add")
    public KoperasiAnggotaEntity addAnggota(@RequestBody KoperasiAnggotaEntity anggota){
        return koperasiAnggotaRepopsitory.save(anggota);
    }

    @PutMapping("/update/{id}")
    KoperasiAnggotaEntity update(@RequestBody KoperasiAnggotaEntity anggota, @PathVariable Integer id) {
//        EnigmaSekolahEntity ent = new EnigmaSekolahEntity();
        return koperasiAnggotaRepopsitory.findById(id)
                .map(ent -> {
                    ent.setNama(anggota.getNama());
                    ent.setNo_hp(anggota.getNo_hp());
                    return koperasiAnggotaRepopsitory.save(ent);
                })
                .orElseGet(() -> {
                    anggota.setId(id);
                    return koperasiAnggotaRepopsitory.save(anggota);
                });
    }
}
