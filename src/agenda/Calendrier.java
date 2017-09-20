package agenda;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Calendrier {
    private short idCalendrier;
    private String libelle;
    private String couleur;
    private int utilisateur;
    private Collection<Abonner> abonnersByIdCalendrier;
    private Utilisateur utilisateurByUtilisateur;
    private Collection<Evenement> evenementsByIdCalendrier;
    private Set<RendezVous> rendezVousByIdCalendrier;

    @Id
    @Column(name = "id_calendrier", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public short getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(short idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "couleur")
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Basic
    @Column(name = "utilisateur", insertable = false, updatable = false)
    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendrier that = (Calendrier) o;

        if (idCalendrier != that.idCalendrier) return false;
        if (utilisateur != that.utilisateur) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (couleur != null ? !couleur.equals(that.couleur) : that.couleur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCalendrier;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (couleur != null ? couleur.hashCode() : 0);
        result = 31 * result + utilisateur;
        return result;
    }

    @OneToMany(mappedBy = "calendrierByIdCalendrier")
    public Collection<Abonner> getAbonnersByIdCalendrier() {
        return abonnersByIdCalendrier;
    }

    public void setAbonnersByIdCalendrier(Collection<Abonner> abonnersByIdCalendrier) {
        this.abonnersByIdCalendrier = abonnersByIdCalendrier;
    }

    @ManyToOne
    @JoinColumn(name = "utilisateur", referencedColumnName = "id_utilisateur", nullable = false)
    public Utilisateur getUtilisateurByUtilisateur() {
        return utilisateurByUtilisateur;
    }

    public void setUtilisateurByUtilisateur(Utilisateur utilisateurByUtilisateur) {
        this.utilisateurByUtilisateur = utilisateurByUtilisateur;
    }

    @OneToMany(mappedBy = "calendrierByCalendrier")
    public Collection<Evenement> getEvenementsByIdCalendrier() {
        return evenementsByIdCalendrier;
    }

    public void setEvenementsByIdCalendrier(Collection<Evenement> evenementsByIdCalendrier) {
        this.evenementsByIdCalendrier = evenementsByIdCalendrier;
    }

    @OneToMany(mappedBy = "calendrierByCalendrier")
    public Set<RendezVous> getRendezVousByIdCalendrier() {
        return rendezVousByIdCalendrier;
    }

    public void setRendezVousByIdCalendrier(Set<RendezVous> rendezVousByIdCalendrier) {
        this.rendezVousByIdCalendrier = rendezVousByIdCalendrier;
    }
}
