package com.example.movieticketbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auditorium")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auditorium_id")
    private Long id;

    @Column(name = "seat_count")
    private Integer seatCount;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonManagedReference
    private Theatre theatre;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Seat> seats;

    @OneToMany(mappedBy = "auditorium", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Screening> screenings;
}
