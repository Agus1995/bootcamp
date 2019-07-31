package com.enigma.koperasi.repository;

import com.enigma.koperasi.entity.KoperasiBarangEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KoperasiBarangRepository extends JpaRepository<KoperasiBarangEntity, Integer> {
    List<KoperasiBarangEntity> findByNama_barang (String barang);
}
