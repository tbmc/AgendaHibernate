package agenda;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Utilisateur {
    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String contact;
    private String pseudo;
    private String motdepasse;
    private Collection<Abonner> abonnersByIdUtilisateur;
    private Collection<Calendrier> calendriersByIdUtilisateur;
    private Collection<InviterU> inviterUSByIdUtilisateur;

    @Id
    @Column(name = "id_utilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "pseudo")
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Basic
    @Column(name = "motdepasse")
    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (idUtilisateur != that.idUtilisateur) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
        if (pseudo != null ? !pseudo.equals(that.pseudo) : that.pseudo != null) return false;
        if (motdepasse != null ? !motdepasse.equals(that.motdepasse) : that.motdepasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (pseudo != null ? pseudo.hashCode() : 0);
        result = 31 * result + (motdepasse != null ? motdepasse.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "utilisateurByIdUtilisateur")
    public Collection<Abonner> getAbonnersByIdUtilisateur() {
        return abonnersByIdUtilisateur;
    }

    public void setAbonnersByIdUtilisateur(Collection<Abonner> abonnersByIdUtilisateur) {
        this.abonnersByIdUtilisateur = abonnersByIdUtilisateur;
    }

    @OneToMany(mappedBy = "utilisateurByUtilisateur")
    public Collection<Calendrier> getCalendriersByIdUtilisateur() {
        return calendriersByIdUtilisateur;
    }

    public void setCalendriersByIdUtilisateur(Collection<Calendrier> calendriersByIdUtilisateur) {
        this.calendriersByIdUtilisateur = calendriersByIdUtilisateur;
    }

    @OneToMany(mappedBy = "utilisateurByIdUtilisateur")
    public Collection<InviterU> getInviterUSByIdUtilisateur() {
        return inviterUSByIdUtilisateur;
    }

    public void setInviterUSByIdUtilisateur(Collection<InviterU> inviterUSByIdUtilisateur) {
        this.inviterUSByIdUtilisateur = inviterUSByIdUtilisateur;
    }
}
