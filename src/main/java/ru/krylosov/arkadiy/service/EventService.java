package ru.krylosov.arkadiy.service;

import ru.krylosov.arkadiy.dao.EventDao;
import ru.krylosov.arkadiy.dao.daoImplementation.EventDaoImpl;
import ru.krylosov.arkadiy.model.Event;

import java.util.List;

public class EventService {

    private final EventDao eventDao;

    public EventService(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public Event getById(Long aLong){
        return eventDao.getById(aLong);
    }

    public List<Event> getAll(){
        return eventDao.getAll();
    }

    public Event save(Event event){
        return eventDao.save(event);
    }

    public Event update(Event event){
        return eventDao.update(event);
    }

    public void deleteById(Long aLong){
        eventDao.deleteById(aLong);
    }
}
