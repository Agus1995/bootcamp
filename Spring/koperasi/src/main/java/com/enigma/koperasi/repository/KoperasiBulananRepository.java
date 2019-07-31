package com.enigma.koperasi.repository;

import com.enigma.koperasi.entity.KoperasiBulananEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KoperasiBulananRepository extends JpaRepository<KoperasiBulananEntity, Integer> {
    List<KoperasiBulananEntity> findByBulanContaining (String bulan);
}
