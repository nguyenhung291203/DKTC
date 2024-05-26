package com.example.be.respository;

import com.example.be.models.entity.ClassSubject;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject,String> {
    @Query("select cs from ClassSubject cs where cs.teacher.id=:teacherId")
    List<ClassSubject> getClassSubjectByTeacherId(@PathParam("teacherId") String teacherId);

    @Query("select p.classSubject from Point p where p.id.studentId=:studentId")
    List<ClassSubject> getClassSubjectByStudentId(@PathParam("studentId") String studentId);
}
