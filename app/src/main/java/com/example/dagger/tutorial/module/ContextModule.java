package com.example.dagger.tutorial.module;

import android.content.Context;

import com.example.dagger.tutorial.ApplicationScope;
import com.example.dagger.tutorial.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @ApplicationScope
    @Provides
    public Context context() {
        return context.getApplicationContext();
    }
}
