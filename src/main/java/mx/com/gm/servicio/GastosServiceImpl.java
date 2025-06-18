/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IGastosDAO;
import mx.com.gm.domain.Gastos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hugo
 */
@Service
public class GastosServiceImpl implements GastosService{

     //Inyectamos una instaancia de la clase de tipo Dao
    @Autowired
    private IGastosDAO gastosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Gastos> listarGastos() {
        return (List<Gastos>) gastosDao.findAll();

    }

    @Override
    @Transactional
    public void gusrdarGastos(Gastos gasto) {

        gastosDao.save(gasto);
    }

    @Override
    @Transactional(readOnly = true)
    public Gastos encontrarGasto(Gastos gasto) {
        return gastosDao.findById(gasto.getIdGasto()).orElse(null);

    }
    
}
