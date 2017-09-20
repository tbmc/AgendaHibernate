package agenda;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Evenement {
    private int idEvenement;
    private String libelle;
    private Timestamp date;
    private short calendrier;
    private Calendrier calendrierByCalendrier;

    @Id
    @Column(name = "id_evenement")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "calendrier", insertable = false, updatable = false)
    public short getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(short calendrier) {
        this.calendrier = calendrier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evenement evenement = (Evenement) o;

        if (idEvenement != evenement.idEvenement) return false;
        if (calendrier != evenement.calendrier) return false;
        if (libelle != null ? !libelle.equals(evenement.libelle) : evenement.libelle != null) return false;
        if (date != null ? !date.equals(evenement.date) : evenement.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvenement;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) calendrier;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "calendrier", referencedColumnName = "id_calendrier", nullable = false)
    public Calendrier getCalendrierByCalendrier() {
        return calendrierByCalendrier;
    }

    public void setCalendrierByCalendrier(Calendrier calendrierByCalendrier) {
        this.calendrierByCalendrier = calendrierByCalendrier;
    }
}
