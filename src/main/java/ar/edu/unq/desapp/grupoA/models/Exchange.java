package ar.edu.unq.desapp.grupoA.models;

import org.joda.time.DateTime;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Exchange")
public class Exchange {

    private static final long serialVersionUID = -3886963290665047361L;
    @Id()
    @GeneratedValue()
    @Column(name = "EXCHANGE_ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserModel userModel;

    @Column(name = "date")
    private Date date;

    public Exchange(Product product, UserModel user) {
        this.product = product;
        this.userModel = user;
        this.date = new DateTime().toDate();
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
