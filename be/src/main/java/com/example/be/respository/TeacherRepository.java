package com.example.be.respository;

import com.example.be.models.entity.Teacher;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query("select t from Teacher t where t.user.username=:username")
    Teacher getTeacherByUserName(@PathParam("username") String username);
}
