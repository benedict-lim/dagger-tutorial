package com.example.dagger.tutorial.module;

import com.example.dagger.tutorial.model.Candy;
import com.example.dagger.tutorial.model.Game;

import dagger.Module;
import dagger.Provides;

@Module
public class PersuasionModule {

    public PersuasionModule() {
    }

    @Provides
    Candy provideCandy() {
        return new Candy();
    }

    @Provides
    Game provideGame() {
        return new Game();
    }
}
