package agenda;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class InviterNonUPK implements Serializable {
    private int idRdv;
    private int idPersonne;

    @Column(name = "id_rdv", insertable = false, updatable = false)
    @Id
    public int getIdRdv() {
        return idRdv;
    }

    public void setIdRdv(int idRdv) {
        this.idRdv = idRdv;
    }

    @Column(name = "id_personne", insertable = false, updatable = false)
    @Id
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InviterNonUPK that = (InviterNonUPK) o;

        if (idRdv != that.idRdv) return false;
        if (idPersonne != that.idPersonne) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRdv;
        result = 31 * result + idPersonne;
        return result;
    }
}
