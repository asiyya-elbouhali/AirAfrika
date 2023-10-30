package com.airafrika.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "flight_number", nullable = true, length = 255)
        private String flightNumber;
        @Basic
        @Column(name = "departure_city", nullable = false, length = 255)
        private String departureCity;

        @Basic
        @Column(name = "arrival_city", nullable = false, length = 255)
        private String arrivalCity;

        @Basic
        @Column(name = "departure_time", nullable = false, length = 255)
         private String departureTime;

        @Basic
        @Column(name = "arrival_time", nullable = false, length = 255)
         private String arrivalTime;

        @Basic
        @Column(name = "date_departure", nullable = false, length = 255)
        @Temporal(TemporalType.DATE)
        private String dateDeparture;

        @Basic
        @Column(name = "date_arrival", nullable = false, length = 255)
        @Temporal(TemporalType.DATE)
        private String  dateArrival;

        @Basic
        @Column(name = "available_seats", nullable = false)
        private Integer availableSeats;

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Basic
    @Column(name = "tarif_mad", nullable = false, precision = 0)
        private Double tarifMad;

    public void setTarifMad(double tarifMad) {
        this.tarifMad = tarifMad;
    }

    @Basic
    @Column(name = "tarif_euro", nullable = false, precision = 0)
        private Double tarifEuro;

    public void setTarifEuro(double tarifEuro) {
        this.tarifEuro = tarifEuro;
    }

    @Basic
    @Column(name = "stopover", nullable = false)
        private boolean stopover;

        @ManyToOne
        @JoinColumn(name = "airline_id", nullable = true)
        private Airline airline;

    public Flight() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime =  arrivalTime;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture =  dateDeparture ;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Double getTarifMad() {
        return tarifMad;
    }

    public void setTarifMad(Double tarifMad) {
        this.tarifMad = tarifMad;
    }

    public Double getTarifEuro() {
        return tarifEuro;
    }

    public void setTarifEuro(Double tarifEuro) {
        this.tarifEuro = tarifEuro;
    }

    public boolean isStopover() {
        return stopover;
    }

    public void setStopover(boolean stopover) {
        this.stopover = stopover;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (stopover != flight.stopover) return false;
        if (id != null ? !id.equals(flight.id) : flight.id != null) return false;
        if (flightNumber != null ? !flightNumber.equals(flight.flightNumber) : flight.flightNumber != null)
            return false;
        if (departureCity != null ? !departureCity.equals(flight.departureCity) : flight.departureCity != null)
            return false;
        if (arrivalCity != null ? !arrivalCity.equals(flight.arrivalCity) : flight.arrivalCity != null) return false;
        if (departureTime != null ? !departureTime.equals(flight.departureTime) : flight.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(flight.arrivalTime) : flight.arrivalTime != null) return false;
        if (dateDeparture != null ? !dateDeparture.equals(flight.dateDeparture) : flight.dateDeparture != null)
            return false;
        if (dateArrival != null ? !dateArrival.equals(flight.dateArrival) : flight.dateArrival != null) return false;
        if (availableSeats != null ? !availableSeats.equals(flight.availableSeats) : flight.availableSeats != null)
            return false;
        if (tarifMad != null ? !tarifMad.equals(flight.tarifMad) : flight.tarifMad != null) return false;
        if (tarifEuro != null ? !tarifEuro.equals(flight.tarifEuro) : flight.tarifEuro != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departureCity != null ? departureCity.hashCode() : 0);
        result = 31 * result + (arrivalCity != null ? arrivalCity.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (dateDeparture != null ? dateDeparture.hashCode() : 0);
        result = 31 * result + (dateArrival != null ? dateArrival.hashCode() : 0);
        result = 31 * result + (availableSeats != null ? availableSeats.hashCode() : 0);
        result = 31 * result + (tarifMad != null ? tarifMad.hashCode() : 0);
        result = 31 * result + (tarifEuro != null ? tarifEuro.hashCode() : 0);
        result = 31 * result + (stopover ? 1 : 0);
         result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        return result;
    }
}
