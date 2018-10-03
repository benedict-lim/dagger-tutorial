package com.example.dagger.tutorial.component;

import com.example.dagger.tutorial.ApplicationScope;
import com.example.dagger.tutorial.module.PicassoModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@ApplicationScope
@Component(modules = PicassoModule.class)
public interface ImageComponent {

    Picasso getPicasso();
}
