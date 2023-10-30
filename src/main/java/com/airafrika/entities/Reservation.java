package com.airafrika.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "passenger_id", nullable = true)
    private Integer passengerId;
    @Basic
    @Column(name = "flight_id", nullable = true)
    private Integer flightId;
    @Basic
    @Column(name = "extras_id", nullable = true)
    private Integer extrasId;
    @Basic
    @Column(name = "reservation_date", nullable = false)
    private Timestamp reservationDate;
    @Basic
    @Column(name = "seat_number", nullable = false)
    private int seatNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getExtrasId() {
        return extrasId;
    }

    public void setExtrasId(Integer extrasId) {
        this.extrasId = extrasId;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (id != that.id) return false;
        if (seatNumber != that.seatNumber) return false;
        if (passengerId != null ? !passengerId.equals(that.passengerId) : that.passengerId != null) return false;
        if (flightId != null ? !flightId.equals(that.flightId) : that.flightId != null) return false;
        if (extrasId != null ? !extrasId.equals(that.extrasId) : that.extrasId != null) return false;
        if (reservationDate != null ? !reservationDate.equals(that.reservationDate) : that.reservationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (passengerId != null ? passengerId.hashCode() : 0);
        result = 31 * result + (flightId != null ? flightId.hashCode() : 0);
        result = 31 * result + (extrasId != null ? extrasId.hashCode() : 0);
        result = 31 * result + (reservationDate != null ? reservationDate.hashCode() : 0);
        result = 31 * result + seatNumber;
        return result;
    }
}
