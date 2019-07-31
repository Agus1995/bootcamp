package com.example.Siswa.repository;

import com.example.Siswa.entity.EnigmaSiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnigmaSiswaRepository extends JpaRepository<EnigmaSiswaEntity, Integer> {
    List<EnigmaSiswaEntity> findByNamaContaining(String nama);
}