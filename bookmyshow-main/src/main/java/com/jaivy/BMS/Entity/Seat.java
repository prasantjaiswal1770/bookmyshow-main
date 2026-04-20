package com.jaivy.BMS.Entity;

import com.jaivy.BMS.Enum.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "seats")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number", nullable = false)  // ← fix
    private String seatNumber;

    @Column(name = "seat_rol")
    private String row;

    @Column(name = "seat_col")
    private Integer col;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type")                      // ← fix
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
}