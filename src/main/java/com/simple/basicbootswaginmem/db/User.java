package com.simple.basicbootswaginmem.db;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
     public User(){
         super();
     }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;
    private String name;
    private int   age;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(Long id){
        this.id =id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
