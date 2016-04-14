package ar.edu.unq.desapp.grupoA.models;
import org.joda.time.DateTime;

import java.util.Date;

public class Exchange {

    private Product product;
    private UserModel user;
    private Date date;

    public Exchange(Product product, UserModel user) {
        this.product = product;
        this.user = user;
        this.date = new DateTime().toDate();
    }
}
