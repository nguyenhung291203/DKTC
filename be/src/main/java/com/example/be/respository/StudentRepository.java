package com.example.be.respository;

import com.example.be.models.entity.Class;
import com.example.be.models.entity.Student;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query("select s from Student s where s.user.username = :username")
    Student findStudentByUserName(@PathParam("username") String username);

    @Query("select Student from StudentClass sc where sc.classEntity.id = :id")
    List<Student> findStudentByClassId(@PathParam("id") int id);
}
