package com.example.be.respository;


import com.example.be.models.entity.Point;
import com.example.be.models.key.PointKey;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, PointKey> {
    @Query("select p from Point p where p.student.id=:studentId")
    List<Point> getListPointsByStudentId(@PathParam("studentId") String studentId);
    @Query("select p from Point p where p.classSubject.id=:classSubjectId")
    List<Point> getListPointsByClassSubjectId(@PathParam("classSubjectId") String classSubjectId);
    @Query("select p from Point p where p.classSubject.subject.id=:subjectId")
    List<Point> getListPointsBySubjectId(@PathParam("subjectId") String subjectId);

    @Query("select sum(p.scoreLaster*p.classSubject.subject.credit)/sum(p.classSubject.subject.credit) from Point p where p.student.id=:studentId and p.actived= true")
    float getGpaByStudentId(@PathParam("studentId") String studentId);

    @Query("select count(p) from Point p where p.student.id=:studentId and p.scoreNumberThree>=4 and p.studied=true")
    int getCompletedByStudentId(@PathParam("studentId") String studentId);

    @Query("select count(p) from Point p where (p.student.id=:studentId and p.scoreNumberThree<4 and p.studied=true)")
    int getDebtByStudentId(@PathParam("studentId") String studentId);
}
