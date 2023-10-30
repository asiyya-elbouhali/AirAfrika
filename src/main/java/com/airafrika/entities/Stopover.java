package com.airafrika.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Stopover {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "airport_name", nullable = false, length = 255)
    private String airportName;
    @Basic
    @Column(name = "arrival_time", nullable = false)
    private Timestamp arrivalTime;
    @Basic
    @Column(name = "departure_time", nullable = false)
    private Timestamp departureTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stopover stopover = (Stopover) o;

        if (id != stopover.id) return false;
        if (airportName != null ? !airportName.equals(stopover.airportName) : stopover.airportName != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(stopover.arrivalTime) : stopover.arrivalTime != null)
            return false;
        if (departureTime != null ? !departureTime.equals(stopover.departureTime) : stopover.departureTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (airportName != null ? airportName.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        return result;
    }
}
