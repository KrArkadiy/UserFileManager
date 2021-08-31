package ru.krylosov.arkadiy.dao.daoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.krylosov.arkadiy.dao.UserDao;
import ru.krylosov.arkadiy.model.User;
import ru.krylosov.arkadiy.util.HibernateSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User getById(Long aLong) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(User.class, aLong);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Users").list();
    }

    @Override
    public User update(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(user);
        tx1.commit();
        session.close();
        return getById(user.getId());
    }

    @Override
    public User save(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(user);
        tx1.commit();
        session.close();
        return user;
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
