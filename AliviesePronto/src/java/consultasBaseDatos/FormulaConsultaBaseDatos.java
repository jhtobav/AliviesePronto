package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import tablas.Formula;
import tablas.ProductoVendido;

public class FormulaConsultaBaseDatos {
    
    EntityManagerFactory emf = ManejoEMFIntermedioPaginas.getEmf();
            
    public Formula crearFormula(Formula formula) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        try{
            em.persist(formula);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println(e);
        }finally{
            em.close();
            return formula;
        }

    }
    
    public Formula modificarListaProductosFormula(List<ProductoVendido> productosVendidos, Formula formula){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Formula nuevaFormula = new Formula();
        
        try {
            nuevaFormula = em.merge(em.find(Formula.class, formula.getId()));
            
            nuevaFormula.setProductoVendidoCollection(productosVendidos);
            
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaFormula;
        }
        
    }

}