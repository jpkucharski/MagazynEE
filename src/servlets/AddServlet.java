package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	@EJB
	MagazynDAO refMagazynDAO;
	
	
	private static final long serialVersionUID = 1L;
       
   
    public AddServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lista", refMagazynDAO.odczytywanieBazyNowa());
		request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Magazyn magazyn1 = new Magazyn();
// Nazwa -------------------------------------------------------
		String nazwa = request.getParameter("nazwaWprowadzana");
		if (nazwa == null || nazwa.equals("")) {
			//out.println("<p style=\"color:red\">Podano zla nazwe tpwaru</p>");
			request.getRequestDispatcher("Pages/add.jsp").forward(request, response);
			return;
		}
		magazyn1.setNazwa(nazwa);
// Ilosc ----------------------------------------------------
		String iloscString = request.getParameter("iloscWprowadzana");

		if (iloscString == null || iloscString.equals("")) {
			//out.println("<p style=\"color:red\">Podano zla ilosc towaru</p>");
			request.getRequestDispatcher("Pages/add.jsp").forward(request, response);
			return;
		}
		int ilosc = Integer.parseInt(iloscString);
		magazyn1.setIlosc(ilosc);
// Cena -------------------------------------------------
		String cenaString = request.getParameter("cenaWprowadzana");

		if (cenaString == null || cenaString.equals("")) {
			//out.println("<p style=\"color:red\">Podano zla cena</p>");
			request.getRequestDispatcher("Pages/add.jsp").forward(request, response);
			return;
		}
		Double cena = Double.parseDouble(cenaString);
		magazyn1.setCena(cena);
//Kategoria -------------------------------------------------
		String kategoria = request.getParameter("kategoriaWprowadzana");
		if (kategoria == null || kategoria.equals("")) {
			//out.println("<p style=\"color:red\">Dupa</p>");
			request.getRequestDispatcher("Pages/add.jsp").forward(request, response);
			return;
		}
		magazyn1.setKategoria(kategoria);
//Opis		
		String opis
		= request.getParameter("opisWprowadzana");
//		if (opis == null || opis.equals("")) {
//			//out.println("<p style=\"color:red\">Podano zly opis twaru</p>");
//			request.getRequestDispatcher("Pages/add.jsp").forward(request, response);
//			return;
//		}
		magazyn1.setOpis(opis);
		
		
//Sprawdzanie ----------------------------------------------
		
		
out.println("Nazwa: " + nazwa);
out.println("Ilosc: " + ilosc);
out.println("Cena: " + cena);
out.println("Kategoria: " + kategoria);
out.println("Opis: " + opis);
		
//Zapisywanie --------------------------------------------------
	
		refMagazynDAO.dodajMagazyn(magazyn1);
//Przekierowywanie do doGet-------------------------------------------
		this.doGet(request, response);
	}

}
