package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = "O nome do aluno não pode ficar vazio.")
    @Pattern(regexp = "^[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do aluno deve começar com letra maiuscula.")
    @Size(max = 50, message = "O comprimento do nome não pode exceder 50 caracteres.")
    String studentName;

    String message;

    Double averageScore;

    @NotEmpty(message = "A lista não pode estar vazia.")
    List<SubjectDTO> subjects;
}
