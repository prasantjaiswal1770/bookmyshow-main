package com.jaivy.BMS.Entity;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "screens")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @Column  ( nullable = false )
    private  String name  ; // AUDI-1 , AUDI-2  LIKE THAT
    private Integer TotalSeat  ;

    @ManyToOne
    @JoinColumn(
            name = "theater_id" , nullable = false
    )
   private  Theater theater  ;


}