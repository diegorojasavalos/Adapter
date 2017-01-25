/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.is2.shelldb;

import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public interface DBadapter {
    
    public void conectarse(String nombreBD) throws SQLException, ClassNotFoundException;
    
    public String ejecutar(String sq1) throws SQLException;
    
    
}
