package com.airafrika.dao;

import com.airafrika.entities.Airline;
import com.airafrika.entities.Flight;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class FlightDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private SessionFactory sessionFactory;
    public FlightDAO(){
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }
    public Flight createFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            flight = null;
            e.printStackTrace();
        }
        return flight;
    }


    public List<Flight> getAllFlights(){
        List<Flight> flights = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Flight> criteriaQuery = builder.createQuery(Flight.class);
            Root<Flight> root = criteriaQuery.from(Flight.class);
            criteriaQuery.select(root);
            List<Flight> results = session.createQuery(criteriaQuery).getResultList();
            flights.addAll(results);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
        }


    public Flight getFlightById(int flightId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Flight flight = session.get(Flight.class, flightId);

            transaction.commit();
            return flight;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteFlight(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class, id);
            if (flight != null) {
                session.delete(flight);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Flight updateFlight(Flight flight) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Flight existingFlight = session.get(Flight.class, flight.getId());

            if (existingFlight != null) {
                // Update the flight properties
                existingFlight.setFlightNumber(flight.getFlightNumber());
                existingFlight.setDepartureCity(flight.getDepartureCity());
                existingFlight.setArrivalCity(flight.getArrivalCity());
                // Update other properties as needed

                session.update(existingFlight);
                transaction.commit();
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            flight = null;
        } finally {
            session.close();
        }

        return flight;
    }

}
