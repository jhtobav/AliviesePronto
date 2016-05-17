package viewBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class NavLinkBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int activePage = 0;

	private String source;

	public void navigateToPage(int page, String source) {
		activePage = page;
                System.out.println(activePage);
		this.source = source;
                System.out.println(this.source);
	}

	public String getPageTitle() {
		return "Page " + (activePage + 1);
	}

	public String getPageContent() {
            System.out.println(source);
		if (source == null) {
			return "loginMedico.xhtml";
		}
		if (0 == activePage)
			return "loginMedico.xhtml";
		if (1 == activePage)
			return "inicio.xhtml";
		return "This is an unknown page.";
	}
        
        public String sendPageContent(){
            return "loginMedico.xhtml";
        }

	public String getPageLook() {
		if (0 == activePage)
			return "primary";
		return "success";
	}
}