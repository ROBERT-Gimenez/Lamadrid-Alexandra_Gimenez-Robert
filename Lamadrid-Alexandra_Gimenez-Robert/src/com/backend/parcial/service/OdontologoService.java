package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao <Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return odontologoDao.registrar(odontologo);
    }

    public Odontologo buscarOdontologoPorId(int id) {
        return odontologoDao.buscarPorId(id);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoDao.listarTodos();
    }


}
