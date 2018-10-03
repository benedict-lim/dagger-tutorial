package com.example.dagger.tutorial.component;

import com.example.dagger.tutorial.ApplicationScope;
import com.example.dagger.tutorial.model.Boy;
import com.example.dagger.tutorial.model.Candy;
import com.example.dagger.tutorial.model.Excursion;
import com.example.dagger.tutorial.model.Game;
import com.example.dagger.tutorial.model.Girl;
import com.example.dagger.tutorial.module.ActivityModule;
import com.example.dagger.tutorial.module.PersuasionModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {ActivityModule.class, PersuasionModule.class})
public interface WeekendComponent {

    Excursion getExcursion();

    Boy getBoy();

    Girl getGirl();

    Candy getCandy();

    Game getGame();
}
