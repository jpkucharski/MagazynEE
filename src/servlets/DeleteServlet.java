package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	@EJB
	MagazynDAO refMagazynDAO;
	
	
	
	private static final long serialVersionUID = 1L;
       
  
    public DeleteServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		refMagazynDAO.kasowanieRekordu(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("lista", refMagazynDAO.odczytywanieBazyNowa());
		request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
//		this.doGet(request, response);
	}

}
