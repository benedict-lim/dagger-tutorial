package com.example.dagger.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dagger.tutorial.component.DaggerImageComponent;
import com.example.dagger.tutorial.component.DaggerWeekendComponent;
import com.example.dagger.tutorial.component.ImageComponent;
import com.example.dagger.tutorial.component.WeekendComponent;
import com.example.dagger.tutorial.module.ActivityModule;
import com.example.dagger.tutorial.module.ContextModule;

public class MainActivity extends AppCompatActivity {

    private static final int STATUS_GO_SHOPPING = 0;
    private static final int STATUS_GO_HOME = 1;
    private static final int STATUS_PERSUADE = 2;

    private int nextStatus = STATUS_GO_SHOPPING;

    private WeekendComponent weekendComponent;
    private ImageComponent imageComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weekendComponent = DaggerWeekendComponent.builder()
                .activityModule(new ActivityModule(this)).build();
        imageComponent = DaggerImageComponent.builder()
                .contextModule(new ContextModule(this)).build();

        setup();
    }

    private void setup() {
        ImageView boyImg = findViewById(R.id.img_boy);
        imageComponent.getPicasso().load(weekendComponent.getBoy().getImageUrl())
                .fit().centerCrop().into(boyImg);
        final TextView boyTxt = findViewById(R.id.txt_boy);

        final ImageView gameImg = findViewById(R.id.img_game);
        imageComponent.getPicasso().load(weekendComponent.getGame().getImageUrl())
                .fit().centerCrop().into(gameImg);

        ImageView girlImg = findViewById(R.id.img_girl);
        imageComponent.getPicasso().load(weekendComponent.getGirl().getImageUrl())
                .fit().centerCrop().into(girlImg);
        final TextView girlTxt = findViewById(R.id.txt_girl);

        final ImageView candyImg = findViewById(R.id.img_candy);
        imageComponent.getPicasso().load(weekendComponent.getCandy().getImageUrl())
                .fit().centerCrop().into(candyImg);

        final Button actionBtn = findViewById(R.id.btn_action);
        actionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (nextStatus) {
                    case STATUS_GO_SHOPPING:
                        nextStatus = STATUS_GO_HOME;
                        actionBtn.setText(R.string.btn_go_home);
                        boyTxt.setText(weekendComponent.getBoy().showExcitement());
                        girlTxt.setText(weekendComponent.getGirl().showExcitement());
                        gameImg.setVisibility(View.GONE);
                        candyImg.setVisibility(View.GONE);
                        break;
                    case STATUS_GO_HOME:
                        nextStatus = STATUS_PERSUADE;
                        actionBtn.setText(R.string.btn_persuade);
                        boyTxt.setText(weekendComponent.getBoy().throwTantrum());
                        girlTxt.setText(weekendComponent.getGirl().throwTantrum());
                        break;
                    case STATUS_PERSUADE:
                        nextStatus = STATUS_GO_SHOPPING;
                        actionBtn.setText(R.string.btn_go_shopping);
                        boyTxt.setText(weekendComponent.getBoy().showSatisfaction());
                        girlTxt.setText(weekendComponent.getGirl().showSatisfaction());
                        gameImg.setVisibility(View.VISIBLE);
                        candyImg.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}
