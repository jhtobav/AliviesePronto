/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultasBaseDatos;

import intermedioPaginas.InicioSesionIntermedioPaginas;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tablas.Farmaceuta;

/**
 *
 * @author jhtob
 */
public class FarmaceutaConsultaBaseDatos {
    
    EntityManagerFactory emf = InicioSesionIntermedioPaginas.getEmf();
        
    public Farmaceuta encontrarPorIdFarmaceuta(Long idFarmaceuta) {
        EntityManager em = emf.createEntityManager();
        Farmaceuta farmaceuta = null;
        try {
            farmaceuta = em.find(Farmaceuta.class
                    , idFarmaceuta);
        } catch (Exception e){
        } finally {
            em.close();
            return farmaceuta;
        }
      
    }  

}