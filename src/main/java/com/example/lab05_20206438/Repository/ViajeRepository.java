package com.example.lab05_20206438.Repository;

import com.example.lab05_20206438.Entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje,Integer> {

}
