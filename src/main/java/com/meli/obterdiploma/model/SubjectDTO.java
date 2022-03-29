package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotEmpty(message = "O nome do assunto não pode ficar vazio.")
    @Pattern(regexp = "^[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do assunto deve começar com a letra maiúscula.")
    @Size(max = 30, message = "O comprimento do assunto não pode exceder 30 caracteres.")
    String name;

    @NotEmpty(message = "A nota não pode estar vazia.")
    @DecimalMin(value = "0", message = "Score must be greater than 100.")
    @DecimalMax(value = "10.0", message = "A nota máxima é 10.0")
    Double score;
}
