package com.example.be.respository;

import com.example.be.models.entity.Class;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class,Integer> {
    @Query("select c from Class c where c.course.name = :courseName")
    List<Class> findByCourseName(@PathParam("courseName") String courseName);

    @Query("select c from Class c where c.course.codeCourse = :codeCourse")
    List<Class> findByCodeCourse(@PathParam("courseName") String codeCourse);

    @Query("select c from Class c where c.teacher.id =:id")
    List<Class> findByTeacherId(@PathParam("id") int id);

    @Query("select Count(c.studentClasses) from Class c where c.id=:id")
    List<Class> countRegistered(@PathParam("id") int id);
}
