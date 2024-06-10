package com.example.be.respository;

import com.example.be.models.entity.Student;
import com.example.be.models.entity.Teacher;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    @Query("select s from Student s where s.classStudent.marjor.university.id=:universityId")
    List<Student> getListStudentsByUniversityId(@PathParam("universityId") String universityId);
    @Query("select s from Student s where s.user.username=:username")
    Student getStudentByUserName(@PathParam("username") String username);
    @Query("select p.student from Point p where p.classSubject.id =:classSubjectId")
    List<Student> getListStudentsByClassSubjectId(@PathParam("classSubjectId") String classSubjectId);
}
