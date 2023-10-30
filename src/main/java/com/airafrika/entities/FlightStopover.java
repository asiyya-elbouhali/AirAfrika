package com.airafrika.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@jakarta.persistence.Table(name = "flight_stopover", schema = "public", catalog = "airafrika")
@jakarta.persistence.IdClass(com.airafrika.entities.FlightStopoverPK.class)
public class FlightStopover {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "flight_id", nullable = false)
    private int flightId;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "stopover_id", nullable = false)
    private int stopoverId;

    public int getStopoverId() {
        return stopoverId;
    }

    public void setStopoverId(int stopoverId) {
        this.stopoverId = stopoverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightStopover that = (FlightStopover) o;

        if (flightId != that.flightId) return false;
        if (stopoverId != that.stopoverId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + stopoverId;
        return result;
    }
}
