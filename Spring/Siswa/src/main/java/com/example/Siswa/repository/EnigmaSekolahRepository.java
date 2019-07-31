package com.example.Siswa.repository;

import com.example.Siswa.entity.EnigmaSekolahEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnigmaSekolahRepository extends JpaRepository<EnigmaSekolahEntity, Integer> {

}
