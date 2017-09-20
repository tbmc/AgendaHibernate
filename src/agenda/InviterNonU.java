package agenda;

import javax.persistence.*;

@Entity
@Table(name = "inviter_non_u", schema = "agenda", catalog = "")
@IdClass(InviterNonUPK.class)
public class InviterNonU {
    private int idRdv;
    private int idPersonne;
    private byte disponibilite;
    private RendezVous rendezVousByIdRdv;
    private Invite inviteByIdPersonne;

    @Id
    @Column(name = "id_rdv", insertable = false, updatable = false)
    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    @Id
    @Column(name = "id_personne", insertable = false, updatable = false)
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Basic
    @Column(name = "disponibilite")
    public byte getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(byte disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InviterNonU that = (InviterNonU) o;

        if (idRdv != that.idRdv) return false;
        if (idPersonne != that.idPersonne) return false;
        if (disponibilite != that.disponibilite) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRdv;
        result = 31 * result + idPersonne;
        result = 31 * result + (int) disponibilite;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_rdv", referencedColumnName = "id_rdv", nullable = false)
    public RendezVous getRendezVousByIdRdv() {
        return rendezVousByIdRdv;
    }

    public void setRendezVousByIdRdv(RendezVous rendezVousByIdRdv) {
        this.rendezVousByIdRdv = rendezVousByIdRdv;
    }

    @ManyToOne
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne", nullable = false)
    public Invite getInviteByIdPersonne() {
        return inviteByIdPersonne;
    }

    public void setInviteByIdPersonne(Invite inviteByIdPersonne) {
        this.inviteByIdPersonne = inviteByIdPersonne;
    }
}
