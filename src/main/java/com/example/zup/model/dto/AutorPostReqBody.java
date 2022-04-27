package com.example.zup.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AutorPostReqBody {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotNull
    @CreatedDate
    // CreatedAt *
    private LocalDateTime instant;

    @Column(length = 400, nullable = false)
    private String description;
}
