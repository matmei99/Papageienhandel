package at.htl.bird.entities;

import javax.persistence.*;

@Entity
@Table(name="T_BIRD")
@NamedQueries(
        {@NamedQuery(name = "Bird.findAll",query = "select b from Bird b")}
)
public class Bird {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int price;
    private String birdId;

    public Bird(String name, int price, String birdId) {
        this.name = name;
        this.price = price;
        this.birdId = birdId;
    }

    public Bird() {
    }

    //region Getter&Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String rasse) {
        name = rasse;
    }

    /*public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }*/

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBirdId() {
        return birdId;
    }

    public void setBirdId(String birdId) {
        this.birdId = birdId;
    }
    //endregion
}
