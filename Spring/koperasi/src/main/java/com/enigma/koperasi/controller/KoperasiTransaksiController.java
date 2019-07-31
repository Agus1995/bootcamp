package com.enigma.koperasi.controller;

import com.enigma.koperasi.entity.KoperasiBarangEntity;
import com.enigma.koperasi.entity.KoperasiBulananEntity;
import com.enigma.koperasi.entity.KoperasiTransaksiEntity;
import com.enigma.koperasi.repository.KoperasiBarangRepository;
import com.enigma.koperasi.repository.KoperasiBulananRepository;
import com.enigma.koperasi.repository.KoperasiTransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
@RequestMapping(path = "/transaksi")
public class KoperasiTransaksiController {
    @Autowired
    KoperasiTransaksiRepository koperasiTransaksiRepository;
    @Autowired
    KoperasiBulananRepository koperasiBulananRepository;
    @Autowired
    KoperasiBarangRepository koperasiBarangRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<KoperasiTransaksiEntity> getList() throws Exception{
        List<KoperasiTransaksiEntity> listTransaksi = koperasiTransaksiRepository.findAll();
        return listTransaksi;
    }
    public KoperasiBarangEntity searchBarang(@RequestParam String q){
        KoperasiBarangEntity res = (KoperasiBarangEntity) koperasiBarangRepository.findByNama_barang(q);
        return res;
    }

    public KoperasiBulananEntity searchBulan(@RequestParam String q){
        KoperasiBulananEntity bRes = (KoperasiBulananEntity) koperasiBulananRepository.findByBulanContaining(q);
        return bRes;
    }

/*    public KoperasiBulananEntity updateBulan (int tot, int id){
        KoperasiBulananEntity input = new KoperasiBulananEntity();
        input.setId(id);
        input.setTotal_transaksi(tot);
        return koperasiBulananRepository.save(input);
    }*/

    @PostMapping("/add")
    public KoperasiTransaksiEntity addTransaksi(@RequestBody KoperasiTransaksiEntity trx){
        KoperasiTransaksiEntity trans = new KoperasiTransaksiEntity();

        KoperasiBarangEntity Barang = searchBarang(trx.getId_barang());
        int a = Barang.getId();
        KoperasiBulananEntity Bulan = searchBulan(trx.getId_bulan());
        int b = Bulan.getId();

        trans.setId_barang(String.valueOf(a));
        trans.setId_bulan(String.valueOf(b));
        trans.setJumlah(trx.getJumlah());

        int hargaTotal = searchBarang(trx.getId_barang()).getHarga();
        trans.setTotal_harga(50000);
     //   updateBulan(hargaTotal, trans.getId_bulan());

        return koperasiTransaksiRepository.save(trans);
    }
}
