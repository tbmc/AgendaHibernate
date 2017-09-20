package agenda;

import javax.persistence.*;

@Entity
@Table(name = "inviter_u", schema = "agenda", catalog = "")
@IdClass(InviterUPK.class)
public class InviterU {
    private int idRdv;
    private int idUtilisateur;
    private Byte disponibilite;
    private RendezVous rendezVousByIdRdv;
    private Utilisateur utilisateurByIdUtilisateur;

    @Id
    @Column(name = "id_rdv", insertable = false, updatable = false)
    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    @Id
    @Column(name = "id_utilisateur", insertable = false, updatable = false)
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Basic
    @Column(name = "disponibilite")
    public Byte getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Byte disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InviterU inviterU = (InviterU) o;

        if (idRdv != inviterU.idRdv) return false;
        if (idUtilisateur != inviterU.idUtilisateur) return false;
        if (disponibilite != null ? !disponibilite.equals(inviterU.disponibilite) : inviterU.disponibilite != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRdv;
        result = 31 * result + idUtilisateur;
        result = 31 * result + (disponibilite != null ? disponibilite.hashCode() : 0);
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
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", nullable = false)
    public Utilisateur getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(Utilisateur utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }
}
