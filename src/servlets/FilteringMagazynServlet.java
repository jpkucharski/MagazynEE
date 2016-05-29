package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FilteringMagazynServlet")
public class FilteringMagazynServlet extends HttpServlet {
	@EJB
	MagazynDAO refMagazynDAO;
	private static final long serialVersionUID = 1L;
	String text;
	String kod;
    public FilteringMagazynServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtering = request.getParameter("filtering");
		String nazwaWstawiana = request.getParameter("frase");
		
		
		if (filtering.equals("byname")&&filtering!=null) {
			
			PrintWriter out = response.getWriter();
			//out.println("<p>Filtering: "+filtering +" Frase: "+nazwaWstawiana+"</p>");
			//text = "SELECT t FROM Magazyn t WHERE t.nazwa ='"+"%"+nazwaWstawiana+"%"+"'";
			//out.println("<p>"+text+"</p>");
			text = nazwaWstawiana;
			kod = "nazwa";
			request.setAttribute("lista",refMagazynDAO.filtrowanieNowe(text, kod));
			request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			
		}
		else if (filtering.equals("bycategory") && filtering != null) {

			PrintWriter out = response.getWriter();
			text = nazwaWstawiana;
			kod = "kategoria";
			//out.println("<p>Filtering: "+filtering +" Frase: "+nazwaWstawiana+"</p>");
			request.setAttribute("lista",refMagazynDAO.filtrowanieNowe(text, kod));
			request.getRequestDispatcher("Pages/lista.jsp").forward(request,response);
		}
		else if (filtering.equals("byprice") && filtering != null) {
			Double priceFrom = Double.parseDouble(request.getParameter("from"));
			Double priceTo = Double.parseDouble(request.getParameter("to"));

			PrintWriter out = response.getWriter();
			Double pFrom = priceFrom;
			Double pTo = priceTo;
			//out.println("<p>Price From: "+ pFrom +" Price To: "+pTo+"</p>");
			request.setAttribute("lista",refMagazynDAO.filtrowanieCena(pFrom, pTo));
			request.getRequestDispatcher("Pages/lista.jsp").forward(request,response);
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.println("<p>Wrong frase!</p>");
			}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
