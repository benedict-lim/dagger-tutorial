package com.example.dagger.tutorial.model;

import javax.inject.Inject;

public class Excursion {

    private Boy boy;
    private Girl girl;

    @Inject
    public Excursion(Boy boy, Girl girl) {
        this.boy = boy;
        this.girl = girl;
    }

    public void goShopping() {
        boy.showExcitement();
        girl.showExcitement();
    }

    public void goHome() {
        boy.throwTantrum();
        girl.throwTantrum();
    }
}
