package com.example.dolapcase.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "createdAt")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deletedAt")
    @JsonFormat(pattern = "dd:MM:yyyy HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime deletedAt;


}
