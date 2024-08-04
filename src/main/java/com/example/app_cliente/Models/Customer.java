package com.example.app_cliente.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String phone;
}
