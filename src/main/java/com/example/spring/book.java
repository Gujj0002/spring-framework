package com.example.spring;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="BOOK")
public class book implements Serializable {

    private static final long serialVersionUID = 5756128887126179776L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public book() {
        super();
    }

    public book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
