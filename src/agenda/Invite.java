package agenda;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Invite {
    private int idPersonne;
    private String nom;
    private String prenom;
    private String contact;
    private Collection<InviterNonU> inviterNonUSByIdPersonne;

    @Id
    @Column(name = "id_personne")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invite invite = (Invite) o;

        if (idPersonne != invite.idPersonne) return false;
        if (nom != null ? !nom.equals(invite.nom) : invite.nom != null) return false;
        if (prenom != null ? !prenom.equals(invite.prenom) : invite.prenom != null) return false;
        if (contact != null ? !contact.equals(invite.contact) : invite.contact != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPersonne;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "inviteByIdPersonne")
    public Collection<InviterNonU> getInviterNonUSByIdPersonne() {
        return inviterNonUSByIdPersonne;
    }

    public void setInviterNonUSByIdPersonne(Collection<InviterNonU> inviterNonUSByIdPersonne) {
        this.inviterNonUSByIdPersonne = inviterNonUSByIdPersonne;
    }
}
