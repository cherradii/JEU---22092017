package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.MetierJeu;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet(description = "Le controleur de l'application web, se base sur le modèle MVC et la technologie Servlet.", urlPatterns = { "/ControleurServlet" })
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MetierJeu metier;
    private String gagnant;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        metier = new MetierJeu();
    }

    @Override
    public void init() throws ServletException {
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("VueJeu.jsp").forward(request, response);
		HttpSession session = request.getSession();
		ModeleJeu mod = new ModeleJeu();
		session.setAttribute("model", mod);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		HttpSession session = request.getSession();
		ModeleJeu mod;
		if(session.getAttribute("model") == null){
			mod = new ModeleJeu();
			session.setAttribute("model", mod);
		} else{
			mod =(ModeleJeu) session.getAttribute("model");
		}
		if(request.getParameter("action").equals("Relancer le jeu")){
			metier.genererSecret();
			metier.setFin(false);
			mod.setHistorique(new ArrayList<String>());
		} else{
		
		//ModeleJeu mod = new ModeleJeu(); // l'enjeu c'est de créer un modèle pour chaque utilisateur, d'où le recours à la notion de session.
		int nb = Integer.parseInt(request.getParameter("nombre"));
		mod.setNombre(nb);
		String rep = metier.jouer(nb);
		if(rep.indexOf("Bravo") >= 0){
			gagnant = request.getRemoteAddr();
		}
		if (rep.indexOf("Le nombre secret qui") >= 0){
			rep = rep + " Le ganant est : "+gagnant;
		}
		mod.getHistorique().add(rep);
		mod.setTentative(mod.getTentative() + 1);
		//request.setAttribute("model", mod);
	 }
		request.getRequestDispatcher("VueJeu.jsp").forward(request, response);
	}

}
