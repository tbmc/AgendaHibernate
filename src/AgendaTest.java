import agenda.Calendrier;
import agenda.RendezVous;
import agenda.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.Date;
import java.util.Set;


public class AgendaTest {
    public static Configuration config = null;
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure() //utilise hibernate.cfg.xml
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Durant");
        utilisateur.setPrenom("Marcel");
        utilisateur.setPseudo("dudur");
        utilisateur.setMotdepasse("secret");
        utilisateur.setContact("153 rue verte, 59310 ORCHIES. tél. : 0320584356");
        session.save(utilisateur);

        // La ca marche au dessus

        Calendrier calendrier = new Calendrier();
        calendrier.setLibelle("Courses");
        calendrier.setCouleur("Vert");
        calendrier.setUtilisateur(utilisateur.getIdUtilisateur());
        calendrier.setUtilisateurByUtilisateur(utilisateur);
        session.save(calendrier);

        /*
        RendezVous rdv = new RendezVous();
        rdv.setDebut(new Date(108, 27, 1, 13, 00));
        // Du 27 Février 2008 à 13h00
        rdv.setFin(new Date(108, 27, 1, 14, 30));
        // au 27 Février 2008 à 14h30
        rdv.setLieu("HyperU");
        rdv.setNote("du beurre");
        rdv.setLibelle("Faire les courses");
        // rdv.setCalendrier(calendrier.getIdCalendrier());
        rdv.setCalendrierByCalendrier(calendrier);
        session.save(rdv);
        Set rdvs = calendrier.getRendezVousByIdCalendrier();
        if(rdvs != null) {
            rdvs.add(rdv);
            calendrier.setRendezVousByIdCalendrier(rdvs);
            session.save(calendrier);
        }

        */
        session.getTransaction().commit();
        session.close();


        System.exit(0);
    }
}