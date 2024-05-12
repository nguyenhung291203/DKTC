package com.example.be.respository;

import com.example.be.models.entity.Result;
import com.example.be.models.key.ResultKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, ResultKey> {
    @Query("SELECT r FROM Result r WHERE r.id.studentId = :studentId")
    List<Result> findByStudentId(@Param("studentId") int studentId);

    @Query("SELECT COUNT(r) FROM Result r WHERE r.id.studentId = :studentId and r.scoreTotal>=4")
    int countCompleted(@Param("studentId") int studentId);

    @Query("SELECT sum(r.scoreTotal*r.course.credit)*0.4/sum(r.course.credit) FROM Result r WHERE r.id.studentId = :studentId and r.scoreTotal>=4")
    float gpa(@Param("studentId") int studentId);
}
