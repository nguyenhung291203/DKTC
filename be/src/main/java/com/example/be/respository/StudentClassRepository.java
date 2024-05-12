package com.example.be.respository;

import com.example.be.models.entity.Class;
import com.example.be.models.entity.Student;
import com.example.be.models.entity.StudentClass;
import com.example.be.models.key.StudentClassKey;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, StudentClassKey> {
    @Query("select sc.classEntity from StudentClass sc where sc.student.id =:id")
    List<Class> findClassesByStudentId(@PathParam("id") int id);

    @Query("select sc.student from StudentClass sc where sc.classEntity.id =:id")
    List<Student> findStudentsByClassId(@PathParam("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO students_classes(student_id, class_id) VALUES (:student_id, :class_id)", nativeQuery = true)
    void insertStudentAndClass(@PathParam("student_id") int student_id, @PathParam("class_id") int class_id);
}
