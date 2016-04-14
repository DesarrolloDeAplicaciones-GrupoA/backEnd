package ar.edu.unq.desapp.grupoA.models;

import java.util.List;

/**
 * Created by Loiacono.P671 on 27/03/2016.
 */
public class Ranking {

    private List<UserModel> usuariosEficientes;

    public Ranking(List<UserModel> userModelList) {
        this.usuariosEficientes = userModelList;
    }

    public List<UserModel> getUsuariosEficientes() {
        return usuariosEficientes;
    }

    public void rankearATodos() {
        usuariosEficientes.forEach(user -> user.setPoints(5000));
    }
}
