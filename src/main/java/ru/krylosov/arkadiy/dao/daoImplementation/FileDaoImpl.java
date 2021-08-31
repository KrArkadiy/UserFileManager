package ru.krylosov.arkadiy.dao.daoImplementation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.krylosov.arkadiy.dao.FileDao;
import ru.krylosov.arkadiy.model.File;
import ru.krylosov.arkadiy.util.HibernateSessionFactory;

import java.util.List;

public class FileDaoImpl implements FileDao {
    @Override
    public File getById(Long aLong) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(File.class, aLong);
    }

    @Override
    public List<File> getAll() {
        return (List<File>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Files").list();
    }

    @Override
    public File update(File file) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(file);
        tx1.commit();
        session.close();
        return getById(file.getId());
    }

    @Override
    public File save(File file) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.saveOrUpdate(file);
        tx1.commit();
        session.close();
        return file;
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
