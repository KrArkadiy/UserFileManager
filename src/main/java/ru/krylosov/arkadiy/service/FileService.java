package ru.krylosov.arkadiy.service;

import ru.krylosov.arkadiy.dao.FileDao;
import ru.krylosov.arkadiy.dao.daoImplementation.FileDaoImpl;
import ru.krylosov.arkadiy.model.File;

import java.util.List;

public class FileService {

    private final FileDao fileDao;

    public FileService(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public File getById(Long aLong){
        return fileDao.getById(aLong);
    }

    public List<File> getAll(){
        return fileDao.getAll();
    }

    public File save(File file){
        return fileDao.save(file);
    }

    public File update(File file){
        return fileDao.update(file);
    }

    public void deleteById(Long aLong){
        fileDao.deleteById(aLong);
    }
}
