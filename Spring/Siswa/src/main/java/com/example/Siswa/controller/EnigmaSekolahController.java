package com.example.Siswa.controller;


import com.example.Siswa.entity.EnigmaSekolahEntity;
import com.exam ple.Siswa.repository.EnigmaSekolahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;

@EnableWebMvc
@RestController
@RequestMapping(path = "/sekolah")
public class EnigmaSekolahController {
    @Autowired
    EnigmaSekolahRepository EnigmaSekolahRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<EnigmaSekolahEntity> getList() throws Exception{
        List<EnigmaSekolahEntity> enigmaSekolahEntity = EnigmaSekolahRepository.findAll();

        return enigmaSekolahEntity;
    }

    @PostMapping("/add")
    public EnigmaSekolahEntity addSiswa(@RequestBody EnigmaSekolahEntity sekolah){
        return EnigmaSekolahRepository.save(sekolah);
    }

/*    @GetMapping(path = {"get/{id}"})
    public ResponseEntity<EnigmaSekolahEntity> findById(@PathVariable Integer id){
        return EnigmaSekolahRepository.findById((int) id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }*/

    @GetMapping(path = {"ambil/{id}"})
    public Optional<EnigmaSekolahEntity> findById(@PathVariable (value = "id") Integer id){
        Optional<EnigmaSekolahEntity> enigmaSekolahEntity = EnigmaSekolahRepository.findById(id);
        return enigmaSekolahEntity;
    }

    @PutMapping("/update/{id}")
    EnigmaSekolahEntity update(@RequestBody EnigmaSekolahEntity sekolah, @PathVariable Integer id) {
        return EnigmaSekolahRepository.findById(id)
                .map(ent -> {
                    ent.setNama(sekolah.getNama());
                    ent.setAlamat(sekolah.getAlamat());
                    ent.setJumlah_Guru(sekolah.getJumlah_Guru());
                    ent.setTelefon(sekolah.getTelefon());
                    return EnigmaSekolahRepository.save(ent);
                })
                .orElseGet(() -> {
                    sekolah.setId(id);
                    return EnigmaSekolahRepository.save(sekolah);
                });
    }

    @DeleteMapping("/delete/{id}")
    void hapus (@PathVariable Integer id) {
        EnigmaSekolahRepository.deleteById(id);
    }


/*    @GetMapping(path = {"get/{id}"})
    public ResponseEntity<EnigmaSekolahEntity> findById(@PathVariable long id){
        return EnigmaSekolahRepository.findById((int) id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }*/


}
