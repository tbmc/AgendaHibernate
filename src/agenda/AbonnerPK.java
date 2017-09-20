package agenda;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AbonnerPK implements Serializable {
    private short idCalendrier;
    private int idUtilisateur;

    @Column(name = "id_calendrier", insertable = false, updatable = false)
    @Id
    public short getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(short idCalendrier) {
        this.idCalendrier = idCalendrier;
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

        AbonnerPK abonnerPK = (AbonnerPK) o;

        if (idCalendrier != abonnerPK.idCalendrier) return false;
        if (idUtilisateur != abonnerPK.idUtilisateur) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idCalendrier;
        result = 31 * result + idUtilisateur;
        return result;
    }
}
