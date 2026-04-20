package com.jaivy.BMS.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ManyToAny;

@Table(name = "Theator")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
     private String name  ;
     @Column(nullable = false)
    private  String addresh  ;

    @ManyToOne
    @JoinColumn(name = "city_id" , nullable = false )
    private City  city  ;



}