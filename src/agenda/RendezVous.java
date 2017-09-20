package agenda;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "rendez_vous", schema = "agenda", catalog = "")
public class RendezVous {
    private int idRdv;
    private String libelle;
    private String lieu;
    private String note;
    private Date debut;
    private Date fin;
    private short calendrier;
    private Collection<InviterNonU> inviterNonUSByIdRdv;
    private Collection<InviterU> inviterUSByIdRdv;
    private Calendrier calendrierByCalendrier;

    @Id
    @Column(name = "id_rdv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
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
    @Column(name = "lieu")
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "debut")
    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    @Basic
    @Column(name = "fin")
    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
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

        RendezVous that = (RendezVous) o;

        if (idRdv != that.idRdv) return false;
        if (calendrier != that.calendrier) return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (lieu != null ? !lieu.equals(that.lieu) : that.lieu != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (debut != null ? !debut.equals(that.debut) : that.debut != null) return false;
        if (fin != null ? !fin.equals(that.fin) : that.fin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRdv;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (lieu != null ? lieu.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (debut != null ? debut.hashCode() : 0);
        result = 31 * result + (fin != null ? fin.hashCode() : 0);
        result = 31 * result + (int) calendrier;
        return result;
    }

    @OneToMany(mappedBy = "rendezVousByIdRdv")
    public Collection<InviterNonU> getInviterNonUSByIdRdv() {
        return inviterNonUSByIdRdv;
    }

    public void setInviterNonUSByIdRdv(Collection<InviterNonU> inviterNonUSByIdRdv) {
        this.inviterNonUSByIdRdv = inviterNonUSByIdRdv;
    }

    @OneToMany(mappedBy = "rendezVousByIdRdv")
    public Collection<InviterU> getInviterUSByIdRdv() {
        return inviterUSByIdRdv;
    }

    public void setInviterUSByIdRdv(Collection<InviterU> inviterUSByIdRdv) {
        this.inviterUSByIdRdv = inviterUSByIdRdv;
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
