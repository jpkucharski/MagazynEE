package servlets;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.sun.mail.imap.SortTerm;

@Stateless
public class MagazynDAO {

	@PersistenceContext
	EntityManager refEntityManager;
	@Resource(lookup = "mojabaza")
	DataSource myDataSource;
	

	

	public List<Magazyn> odczytywanieBazySortowana(String text) {
		Query q = refEntityManager.createQuery(text);
		List<Magazyn> lista = q.getResultList();
		return lista;
	}

	public List<Magazyn> odczytywanieBazyNowa() {
		Query q = refEntityManager.createQuery("SELECT t FROM Magazyn t"); /* zapytanie JPQL*/
		List<Magazyn> lista = q.getResultList();
		return lista;
	}

	public void dodajMagazyn(Magazyn s) {
		refEntityManager.persist(s);
	}

	// ------------------------------------
	public Magazyn znajdzMagazyn(int id) {
		return refEntityManager.find(Magazyn.class, id);
	}

	public void kasowanieRekordu(int id) {
		refEntityManager.remove(znajdzMagazyn(id));
	}

	// -----------------------------------------

	public void updateMagazyn(Magazyn s) {
		refEntityManager.merge(s);
		refEntityManager.flush();

	}
//	public List<Magazyn> filtrowanieMagazyn(String text) {
//		
//		Query q = refEntityManager.createQuery("SELECT t FROM Magazyn t WHERE t.nazwa LIKE :x");
//			   // .createQuery("SELECT st from Hardware st where st.staff.id LIKE :x");
//			q.setParameter("x", '%' + text + '%');
//		
//		
//		//Query q = refEntityManager.createQuery(text);
//		List<Magazyn> lista = q.getResultList();
//		return lista;
//	}
	public List<Magazyn> filtrowanieNowe(String text, String kod) {
		
		Query q = refEntityManager.createQuery("SELECT t FROM Magazyn t WHERE t."+kod+" LIKE :x");
		q.setParameter("x", '%' + text + '%');
		List<Magazyn> lista = q.getResultList();
		return lista;
	}

	public List<Magazyn> filtrowanieCena(Double  pFrom, Double pTo) {

		Query q = refEntityManager.createQuery("SELECT t FROM Magazyn t WHERE t.cena BETWEEN :x AND :y");
		q.setParameter("x", pFrom);
		q.setParameter("y", pTo);
		List<Magazyn> lista = q.getResultList();
		return lista;
	}
	
	
}
