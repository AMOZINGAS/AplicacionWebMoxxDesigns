/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.mx.moxxdesignsdominio.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author olive
 */
public class Conexion implements IConexion {

    /**
     * Constructor por defecto de la clase de conexión.
     */
    public Conexion() {
    }

    /**
     * Crea y devuelve un EntityManager para interactuar con la base de datos.
     * 
     * @return EntityManager para interactuar con la base de datos.
     */
    @Override
    public EntityManager crearConexion() {
        
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("MoxxDesignsPU");
        
        EntityManager em = emFactory.createEntityManager();

        return em;
    }

}
