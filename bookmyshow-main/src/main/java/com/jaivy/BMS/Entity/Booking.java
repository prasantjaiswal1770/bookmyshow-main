package com.jaivy.BMS.Entity;


import com.jaivy.BMS.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "booking")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user  ;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show  ;

   @ManyToMany
   @JoinTable(
           name = "booking_seats" ,
           joinColumns = @JoinColumn(name="booking_id") ,
           inverseJoinColumns = @JoinColumn(name = "seat_id")

   )
    private List<Seat> seats  ;

    private double totalPrice  ;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus  ;

    private LocalDateTime bookedAt ;

    @PrePersist
    private void onCreate() {
        this.bookedAt = LocalDateTime.now() ;
        if(bookingStatus == null ) {
            this.bookingStatus = BookingStatus.CONFIRMED ;
        }
    }

}