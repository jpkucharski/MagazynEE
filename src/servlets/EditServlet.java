package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	@EJB
	MagazynDAO refMagazynDAO;

	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		// out.println("<p style=\"color:red\">Zaznaczono rekord o id: "+request.getParameter("id")+"</p>");
		Magazyn pojedynczyRekord = refMagazynDAO.znajdzMagazyn(Integer
				.parseInt(request.getParameter("id")));

		List<Magazyn> listaPojRekordu = new ArrayList<>();
		listaPojRekordu.add(pojedynczyRekord);

		request.setAttribute("lista", listaPojRekordu);
		request.getRequestDispatcher("Pages/Edit.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		// out.println("<p>Wywolano metode doGet z EditServlet</p>");

	
		
		
		PrintWriter out = response.getWriter();
		Magazyn magazyn1 = new Magazyn();
		
//ID -----------------------------------------------			
		String id= request.getParameter("idZamiana");
		int idInt = Integer.parseInt(id);
		magazyn1.setId(idInt);
		
// Nazwa -------------------------------------------------------
		String nazwa = request.getParameter("nazwaZamiana");
		if (nazwa == null || nazwa.equals("")) {
			out.println("<p style=\"color:red\">Podano zla nazwe tpwaru</p>");
			return;
		}
		magazyn1.setNazwa(nazwa);
// Ilosc ----------------------------------------------------
		String iloscString = request.getParameter("iloscZamiana");

		if (iloscString == null || iloscString.equals("")) {
			out.println("<p style=\"color:red\">Podano zla ilosc towaru</p>");
			return;
		}
		int ilosc = Integer.parseInt(iloscString);
		magazyn1.setIlosc(ilosc);
// Cena -------------------------------------------------
		String cenaString = request.getParameter("cenaZamiana");

		if (cenaString == null || cenaString.equals("")) {
			out.println("<p style=\"color:red\">Podano zla cena</p>");
			return;
		}
		Double cena = Double.parseDouble(cenaString);
		magazyn1.setCena(cena);
// Kategoria -------------------------------------------------
		String kategoria = request.getParameter("kategoriaZamiana");
		if (kategoria == null || kategoria.equals("")) {
			out.println("<p style=\"color:red\">Dupa</p>");
			return;
		}
		magazyn1.setKategoria(kategoria);
// Opis
		String opis = request.getParameter("opisZamiana");
		if (opis == null || opis.equals("")) {
			out.println("<p style=\"color:red\">Podano zly opis twaru</p>");
			return;
		}
		magazyn1.setOpis(opis);

//Zapisywanie bazy --------------------------------------------------------		
		refMagazynDAO.updateMagazyn(magazyn1);
//WYswietlanie bazy ----------------------------------------------------		
		request.setAttribute("lista", refMagazynDAO.odczytywanieBazyNowa());
		request.getRequestDispatcher("Pages/lista.jsp").forward(request, response);
		
		
		
		
	}

}
