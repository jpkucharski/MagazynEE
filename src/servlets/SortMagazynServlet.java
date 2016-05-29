package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.MagazynDAO;

@WebServlet("/SortMagazynServlet")
public class SortMagazynServlet extends HttpServlet {

	@EJB
	MagazynDAO refMagazynDAO;
	private static final long serialVersionUID = 1L;
	String text;
	Boolean przelacznik1=true;
	Boolean przelacznik2=true;
	Boolean przelacznik3=true;
	Boolean przelacznik4=true;
	Boolean przelacznik5=true;
	
	public SortMagazynServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String Text = request.getParameter("sort");
		
		 if (Text.equals("id")) {

			if (przelacznik4 == true) {
				text = "SELECT t FROM Magazyn t ORDER BY t.id ASC";
				przelacznik4 = false;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
			else {
				text = "SELECT t FROM Magazyn t ORDER BY t.id DESC";
				przelacznik4 = true;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
		}
		else if (Text.equals("nazwa")) {

			if (przelacznik1 == true) {
				text = "SELECT t FROM Magazyn t ORDER BY t.nazwa ASC";
				przelacznik1 = false;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			} else {
				text = "SELECT t FROM Magazyn t ORDER BY t.nazwa DESC";
				przelacznik1 = true;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
		}
		else if (Text.equals("ilosc")) {

			if (przelacznik3 == true) {
				text = "SELECT t FROM Magazyn t ORDER BY t.ilosc ASC";
				przelacznik3 = false;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
			else {
				text = "SELECT t FROM Magazyn t ORDER BY t.ilosc DESC";
				przelacznik3 = true;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
		}	
		else if (Text.equals("cena")) {

			if (przelacznik2 == true) {
				text = "SELECT t FROM Magazyn t ORDER BY t.cena ASC";
				przelacznik2 = false;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
			else {
				text = "SELECT t FROM Magazyn t ORDER BY t.cena DESC";
				przelacznik2 = true;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
		} 
		else if (Text.equals("kategoria")) {

			if (przelacznik5 == true) {
				text = "SELECT t FROM Magazyn t ORDER BY t.kategoria ASC";
				przelacznik5 = false;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
			else {
				text = "SELECT t FROM Magazyn t ORDER BY t.kategoria DESC";
				przelacznik5 = true;
				request.setAttribute("lista",refMagazynDAO.odczytywanieBazySortowana(text));
				request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
			}
		}  
		else {
			PrintWriter out = response.getWriter();
			out.println("<p>Podano zly parametr</p>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
