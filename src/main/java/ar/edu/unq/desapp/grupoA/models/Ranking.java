package ar.edu.unq.desapp.grupoA.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Loiacono.P671 on 27/03/2016.
 */
@Entity
@Table(name = "Ranking")
public class Ranking {

    @Id()
    @GeneratedValue()
    @Column(name = "ROUTE_ID")
    private int id;

    @OneToMany
    private Set<UserModel> usuariosEficientes;

    public Ranking(Set<UserModel> userModelList) {
        this.usuariosEficientes = userModelList;
    }

    public Set<UserModel> getUsuariosEficientes() {
        return usuariosEficientes;
    }

    public void rankearATodos() {
        usuariosEficientes.forEach(user -> user.setPoints(5000));
    }
}
