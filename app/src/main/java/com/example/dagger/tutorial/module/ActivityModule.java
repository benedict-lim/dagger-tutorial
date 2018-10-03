package com.example.dagger.tutorial.module;

import android.app.Activity;
import android.content.Context;

import com.example.dagger.tutorial.ApplicationScope;
import com.example.dagger.tutorial.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @ActivityContext
    @ApplicationScope
    @Provides
    public Context context() {
        return context;
    }
}
