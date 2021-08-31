package ru.krylosov.arkadiy.controller;

import ru.krylosov.arkadiy.dao.FileDao;
import ru.krylosov.arkadiy.dao.daoImplementation.FileDaoImpl;
import ru.krylosov.arkadiy.model.File;
import ru.krylosov.arkadiy.service.FileService;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet()
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    public File getById(Long aLong) {
        return fileService.getById(aLong);
    }

    public List<File> getAll() {
        return fileService.getAll();
    }

    public File save(File file) {
        return fileService.save(file);
    }

    public File update(File file) {
        return fileService.update(file);
    }

    public void deleteById(Long aLong) {
        fileService.deleteById(aLong);
    }
}
