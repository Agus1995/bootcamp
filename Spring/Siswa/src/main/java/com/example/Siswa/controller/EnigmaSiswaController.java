package com.example.Siswa.controller;

import com.example.Siswa.entity.EnigmaSekolahEntity;
import com.example.Siswa.entity.EnigmaSiswaEntity;
import com.example.Siswa.repository.EnigmaSiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@EnableWebMvc
@RestController
@RequestMapping(path = "/siswa")

public class EnigmaSiswaController {
    @Autowired
    EnigmaSiswaRepository EnigmaSiswaRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<EnigmaSiswaEntity> getList() throws Exception{
        List<EnigmaSiswaEntity> enigmaSiswaEntity = EnigmaSiswaRepository.findAll();
        return enigmaSiswaEntity;
    }

    @PostMapping("/add")
//    @ResponseBody
    public EnigmaSiswaEntity addSiswa(@RequestBody EnigmaSiswaEntity siswa){
        return EnigmaSiswaRepository.save(siswa);
    }

    @GetMapping(path = {"get/{id}"})
    public ResponseEntity<EnigmaSiswaEntity> findById(@PathVariable Integer id){
        return EnigmaSiswaRepository.findById((int) id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/get"})
    public ResponseEntity<EnigmaSiswaEntity> getone(@RequestParam Integer id){
        return EnigmaSiswaRepository.findById((int) id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

//    @PutMapping("/update/{id}")
//    EnigmaSiswaEntity update(@RequestBody EnigmaSiswaEntity siswa, @PathVariable Integer id) {
//        EnigmaSekolahEntity ent = new EnigmaSekolahEntity();
//        return EnigmaSiswaRepository.findById(id)


/*                .map(ent -> {
                    ent.setNama(siswa.getNama());
                    ent.setKelas(siswa.getKelas());
                    ent.setNohp(siswa.getNohp());

                    return EnigmaSiswaRepository.save(ent);
                })
                .orElseGet(() -> {
*//*                    siswa.setId(id);
                    return EnigmaSiswaRepository.save(siswa);*//*
                });*/
    //}

    @PutMapping("update/{id}")
    public String updt (@RequestBody EnigmaSiswaEntity siswa, @PathVariable Integer id){
        Optional<EnigmaSiswaEntity> ent = EnigmaSiswaRepository.findById(id);

        if (ent.isPresent()){
            EnigmaSiswaEntity input = new EnigmaSiswaEntity();
            input.setId(id);
            input.setNama(siswa.getNama());
            input.setKelas(siswa.getKelas());
            input.setNohp(siswa.getNohp());
            EnigmaSiswaRepository.save(input);
            return "Input Success";
        }
        else {
            return "Id "+ id + " tidak ditemukan";
        }

    }

    @DeleteMapping("/delete/{id}")
    void hapus (@PathVariable Integer id) {
        EnigmaSiswaRepository.deleteById(id);
    }

    @GetMapping(path = {"/search"})
    public List<EnigmaSiswaEntity> search(@RequestParam String q){
        List<EnigmaSiswaEntity> res = EnigmaSiswaRepository.findByNamaContaining(q);
        return res;
    }

}
