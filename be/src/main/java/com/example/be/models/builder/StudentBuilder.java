package com.example.be.models.builder;
import com.example.be.models.entity.Result;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder
public class StudentBuilder {
    private int id;
    private String name;
    private String address;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private String majorName;
}
