package com.example.dagger.tutorial.model;

import android.content.Context;

import com.example.dagger.tutorial.R;
import com.example.dagger.tutorial.qualifier.ActivityContext;

import javax.inject.Inject;

public class Girl implements Child {

    private Context context;

    @Inject
    public Girl(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public String showExcitement() {
        return context.getString(R.string.txt_girl_show_excitement);
    }

    @Override
    public String throwTantrum() {
        return context.getString(R.string.txt_girl_throw_tantrum);
    }

    @Override
    public String showSatisfaction() {
        return context.getString(R.string.txt_girl_show_satisfaction);
    }

    @Override
    public String getImageUrl() {
        return "https://image.shutterstock.com/image-vector/cute-school-girl-cartoon-450w-1010464225.jpg";
    }
}
