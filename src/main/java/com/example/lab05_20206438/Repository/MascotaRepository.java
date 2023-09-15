package com.example.lab05_20206438.Repository;

import com.example.lab05_20206438.Entity.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface MascotaRepository extends JpaRepository<Mascotas,Integer> {
}
