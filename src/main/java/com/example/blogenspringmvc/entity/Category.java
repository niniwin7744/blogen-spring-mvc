package com.example.blogenspringmvc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePosted;
    @OneToMany(mappedBy = "category")
    private List<Post> postsList=new ArrayList<>();

    public void addPosts(Post post){
        post.setCategory(this);
        this.postsList.add(post);
    }
}
