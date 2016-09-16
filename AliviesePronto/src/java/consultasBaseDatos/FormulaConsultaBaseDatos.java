package consultasBaseDatos;

import intermedioPaginas.ManejoEMFIntermedioPaginas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
    
    public Formula despacharFormula(Long idFormula){
        
        EntityManager em = emf.createEntityManager();  
        
        em.getTransaction().begin();
        
        Formula nuevaFormula = new Formula();
        
        try {
            nuevaFormula = em.merge(em.find(Formula.class, idFormula));
            
            nuevaFormula.setEstado(false);
            
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
            return nuevaFormula;
        }
        
    }
    
    public List<Formula> obtenerFormulasSinDespachar(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Formula> formulas = null;

        try {
            q = em.createNamedQuery("Formula.findByEstado", Formula.class);
            q.setParameter("estado", true);
            formulas = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return formulas;
        }
        
    }

    
    public List<Formula> obtenerFormulasDespachadas(){
            
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query q;

        List<Formula> formulas = null;

        try {
            q = em.createNamedQuery("Formula.findByEstado", Formula.class);
            q.setParameter("estado", false);
            formulas = q.getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
            return formulas;
        }
        
    }
    
}