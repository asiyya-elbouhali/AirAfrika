package com.airafrika.dao;

import com.airafrika.entities.Airline;
import jakarta.ejb.Stateless;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class AirlineDAO {
    private SessionFactory sessionFactory;

    public AirlineDAO() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public Airline createAirline(Airline airline) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(airline);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            airline = null;
            e.printStackTrace();
        }
        return airline;
    }

    public Airline getAirline(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Airline.class, id);
        } finally {
            session.close();
        }
    }


    public List<Airline> getAllAirlines() {
        List<Airline> airlines = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Airline> criteriaQuery = builder.createQuery(Airline.class);
            Root<Airline> root = criteriaQuery.from(Airline.class);
            criteriaQuery.select(root);
            List<Airline> results = session.createQuery(criteriaQuery).getResultList();
            airlines.addAll(results);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return airlines;
    }

    public Airline updateAirline(Airline airline) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(airline);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return airline;
    }

    public void deleteAirline(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Airline airline = session.get(Airline.class, id);
            if (airline != null) {
                session.delete(airline);
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
    public Airline getAirlineById(int airlineId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Airline airline = session.get(Airline.class, airlineId);

            transaction.commit();
            return airline;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
