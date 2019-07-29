package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 博客
 * @author Qzwy
 */
@Data
@Entity
@Table(name = "Blog")
public class Blog implements Serializable {
    private static final long serialVersionUID = 5565882873621701842L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date crtTime;

    @Column
    private Long userId;

    @Column
    private String name;

    @Column
    private String description;

    @Column(length = 10000)
    private String details;

}








