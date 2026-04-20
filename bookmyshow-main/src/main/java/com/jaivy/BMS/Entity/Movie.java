package com.jaivy.BMS.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    @Column(name = "duration_in_minutes")
    private Integer durationInMinutes;

    private String genre;

    @Column(name = "title")
    private String title;

    private double rating;

    @Column(name = "poster_url")
    private String posterUrl;

    @Column(name = "realese_date")
    private LocalDate realeseDate;

    private String description;
}