package org.example.productmanager.user;

import jakarta.persistence.*;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String title;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String todo;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;


    }
}