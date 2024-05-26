package com.example.be.respository;

import com.example.be.models.entity.Marjor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarjorRepository extends JpaRepository<Marjor,String> {
}
