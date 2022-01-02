package com.example.springbootajax.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private Integer id;
    private String student_name;
    private Integer yw;
    private Integer sx;
    private Integer yy;
    private Integer zyk;
}
