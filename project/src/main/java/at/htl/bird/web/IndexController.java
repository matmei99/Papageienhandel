package at.htl.bird.web;

import at.htl.bird.business.BirdFacade;
import at.htl.bird.business.PillFacade;
import at.htl.bird.business.PillPartFacade;
import at.htl.bird.entities.Bird;
import at.htl.bird.entities.Pill;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
//@Model
public class IndexController {
    @Inject
    BirdFacade birdRepository;
    @Inject
    PillPartFacade pillPartRepository;
    @Inject
    PillFacade pillRepository;

    Bird selectedBird;

    public Bird getSelectedBird() {
        return selectedBird;
    }

    public void setSelectedBird(Bird selectedBird) {
        this.selectedBird = selectedBird;
    }

    public List<Bird> getBirds(){
        return birdRepository.getBirds();
    }

    public List<Pill> getPills(){
        return pillRepository.getPills();
    }

    public void save(){
        if(selectedBird!=null) {
            birdRepository.update(selectedBird);
        }
    }

}
