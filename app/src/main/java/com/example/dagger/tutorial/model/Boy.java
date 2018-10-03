package com.example.dagger.tutorial.model;

import android.content.Context;

import com.example.dagger.tutorial.R;
import com.example.dagger.tutorial.qualifier.ActivityContext;

import javax.inject.Inject;

public class Boy implements Child {

    private Context context;

    @Inject
    public Boy(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public String showExcitement() {
        return context.getString(R.string.txt_boy_show_excitement);
    }

    @Override
    public String throwTantrum() {
        return context.getString(R.string.txt_boy_throw_tantrum);
    }

    @Override
    public String showSatisfaction() {
        return context.getString(R.string.txt_boy_show_satisfaction);
    }

    @Override
    public String getImageUrl() {
        return "https://image.shutterstock.com/image-vector/cartoon-boy-giving-you-thumbs-450w-143614309.jpg";
    }
}
