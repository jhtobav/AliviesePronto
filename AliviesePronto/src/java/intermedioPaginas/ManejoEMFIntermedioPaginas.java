package intermedioPaginas;

import static intermedioPaginas.ManejoEMFIntermedioPaginas.emf;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="manejoEMFIntermedioPaginas")
@SessionScoped
public class ManejoEMFIntermedioPaginas {
    
    public static EntityManagerFactory emf = null;

    public ManejoEMFIntermedioPaginas() {
        
        emf = Persistence
            .createEntityManagerFactory("AlivieseProntoPU");
        
        System.out.println("INICIO");
        
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        ManejoEMFIntermedioPaginas.emf = emf;
    }
    
    @PreDestroy
    public void destruct()
    {
        emf.close();
    }
}
