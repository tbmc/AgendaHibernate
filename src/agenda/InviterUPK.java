package agenda;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class InviterUPK implements Serializable {
    private int idRdv;
    private int idUtilisateur;

    @Column(name = "id_rdv", insertable = false, updatable = false)
    @Id
    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    @Column(name = "id_utilisateur", insertable = false, updatable = false)
    @Id
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

        InviterUPK that = (InviterUPK) o;

        if (idRdv != that.idRdv) return false;
        if (idUtilisateur != that.idUtilisateur) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRdv;
        result = 31 * result + idUtilisateur;
        return result;
    }
}
