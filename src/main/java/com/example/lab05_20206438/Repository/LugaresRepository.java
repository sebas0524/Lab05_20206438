package com.example.lab05_20206438.Repository;


import com.example.lab05_20206438.Entity.Lugares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugaresRepository extends JpaRepository<Lugares,Integer> {
}
