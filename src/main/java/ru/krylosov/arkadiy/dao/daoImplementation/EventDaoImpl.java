package ru.krylosov.arkadiy.dao.daoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.krylosov.arkadiy.dao.EventDao;
import ru.krylosov.arkadiy.model.Event;
import ru.krylosov.arkadiy.util.HibernateSessionFactory;

import java.util.List;

public class EventDaoImpl implements EventDao {
    @Override
    public Event getById(Long aLong) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Event.class, aLong);
    }

    @Override
    public List<Event> getAll() {
        return (List<Event>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM events").list();
    }

    @Override
    public Event update(Event event) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(event);
        tx1.commit();
        session.close();
        return getById(event.getId());

    }

    @Override
    public Event save(Event event) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(event);
        tx1.commit();
        session.close();
        return event;
    }

    @Override
    public void deleteById(Long aLong) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(getById(aLong));
        tx1.commit();
        session.close();
    }
}
