package at.htl.bird.entities;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="T_PILL")
public class Pill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<Pillpart> pillPart;
    private int price=0;

    //region Constructer

    public Pill() {
        pillPart = new LinkedList<Pillpart>();
    }

    public Pill(List<Pillpart> pillPart) {
        this.pillPart = pillPart;
    }

    //endregion

    private void CalcSum(){
        for (int i=0;i<pillPart.size();i++){
            price +=pillPart.get(i).getPrice();
        }
    }

    public void addPillPart(Pillpart p1){
        pillPart.add(p1);
    }

    //region Getter&Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pillpart> getPillPart() {
        return pillPart;
    }

    public void setPillPart(List<Pillpart> pillPart) {
        this.pillPart = pillPart;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int sum) {
        price = sum;
    }
    //endregion
}
