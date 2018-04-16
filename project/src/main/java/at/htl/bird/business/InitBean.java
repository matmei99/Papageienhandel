package at.htl.bird.business;

import at.htl.bird.entities.Bird;
import at.htl.bird.entities.Pill;
import at.htl.bird.entities.Pillpart;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitBean {
    @Inject
    BirdFacade birdRepository;
    @Inject
    PillPartFacade pillPartRepository;
    @Inject
    PillFacade pillRepository;

    public InitBean() {
    }

    @PostConstruct
    private void init() {
        Bird b1 = new Bird("Rotbauchpapagei", 450, "A04 14 7,5 001");
        Bird b2 = new Bird("Rotrückenara", 1200, "A04 14 7,5 002");
        Bird b3 = new Bird("Jandayasittich", 200, "A04 14 7,5 003");
        birdRepository.create(b1);
        birdRepository.create(b2);
        birdRepository.create(b3);

        Pillpart p1 = new Pillpart(2, b1);
        Pillpart p2 = new Pillpart(4, b2);
        Pillpart p3 = new Pillpart(1, b3);
        pillPartRepository.create(p1);
        pillPartRepository.create(p2);
        pillPartRepository.create(p3);

        Pill pill = new Pill();
        pill.addPillPart(p1);
        pill.addPillPart(p2);
        pill.addPillPart(p3);

        pillRepository.create(pill);
    }
}
