package com.springBootTutoriol.devtiro.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    public Author() {
    }

    public Author(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Author(Long id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
