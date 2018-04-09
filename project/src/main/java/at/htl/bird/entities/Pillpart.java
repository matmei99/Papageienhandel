package at.htl.bird.entities;

import javax.persistence.*;

@Entity
@Table(name="T_PILLPART")
@NamedQueries(
        {@NamedQuery(name = "PillPart.findAll",query = "select p from Pillpart p")}
)
public class Pillpart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int anz;

    @OneToOne
    private Bird bird;

    public Pillpart() {
    }

    public int getPrice(){
        return bird.getPrice()*anz;
    }

    public Pillpart(int anz, Bird bird) {
        this.anz = anz;
        this.bird = bird;
    }

    //region Getter&Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnz() {
        return anz;
    }

    public void setAnz(int anz) {
        this.anz = anz;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }
    //endregion
}
