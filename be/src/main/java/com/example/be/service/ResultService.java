package com.example.be.service;

import com.example.be.models.builder.ResultBuilder;
import com.example.be.models.entity.Result;
import com.example.be.models.mapper.ResultMapper;
import com.example.be.respository.ResultRepository;
import com.example.be.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<ResultBuilder> getListResult() {
        List<Result> results = resultRepository.findAll();
        return results.stream().map(result -> ResultMapper.mapResultToResultBuilder(result)).collect(Collectors.toList());
    }

    public List<ResultBuilder> getListResultByStudentId(int id) {
        List<Result> results = resultRepository.findByStudentId(id);
        return results.stream().map(result -> ResultMapper.mapResultToResultBuilder(result)).collect(Collectors.toList());
    }

}
