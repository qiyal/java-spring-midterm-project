package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            },
            mappedBy = "books"
    )
    private Set<Client> client;

    public Book() {}

    public Book(Long id, String name, Integer price, Set<Client> client) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.client = client;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", client=" + client +
                '}';
    }
}
