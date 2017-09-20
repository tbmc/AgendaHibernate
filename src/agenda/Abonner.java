package agenda;

import javax.persistence.*;

@Entity
@IdClass(AbonnerPK.class)
public class Abonner {
    private short idCalendrier;
    private int idUtilisateur;
    private Calendrier calendrierByIdCalendrier;
    private Utilisateur utilisateurByIdUtilisateur;

    @Id
    @Column(name = "id_calendrier", insertable = false, updatable = false)
    public short getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(short idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    @Id
    @Column(name = "id_utilisateur", insertable = false, updatable = false)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abonner abonner = (Abonner) o;

        if (idCalendrier != abonner.idCalendrier) return false;
        if (idUtilisateur != abonner.idUtilisateur) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCalendrier;
        result = 31 * result + idUtilisateur;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_calendrier", referencedColumnName = "id_calendrier", nullable = false)
    public Calendrier getCalendrierByIdCalendrier() {
        return calendrierByIdCalendrier;
    }

    public void setCalendrierByIdCalendrier(Calendrier calendrierByIdCalendrier) {
        this.calendrierByIdCalendrier = calendrierByIdCalendrier;
    }

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", nullable = false)
    public Utilisateur getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(Utilisateur utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }
}
