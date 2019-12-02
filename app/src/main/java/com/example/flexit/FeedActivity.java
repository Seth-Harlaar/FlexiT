package com.example.flexit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.andrognito.flashbar.Flashbar;
import com.google.firebase.auth.FirebaseAuth;

public class FeedActivity extends AppCompatActivity {

    private Button map;
    private Button workout;
    private Button schedule;
    private Button upload;
    private  Button clock;
    private Button BMI;
    private Button music;
    private ImageView profile, logout, setting;
    private Flashbar flashbar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        map = (Button) findViewById(R.id.button_map);
        workout = (Button) findViewById(R.id.button_workout);
        schedule = (Button) findViewById(R.id.button_schedule);
        clock = (Button) findViewById(R.id.button_clock);
        BMI = (Button) findViewById(R.id.button_BMI);
        music =(Button)findViewById(R.id.button_music);
        profile =(ImageView) findViewById(R.id.button_viewprofile);
        logout =(ImageView)findViewById(R.id.logout_view);
        setting = (ImageView)findViewById(R.id.setting_view);

        flashbar = displayQuote();
        flashbar.show();

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*finish();*/
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }
        });
        // scheduler below
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*finish();*/
                startActivity(new Intent(getApplicationContext(), ScheduleActivity.class));
            }
        });

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* finish();*/
                startActivity(new Intent(getApplicationContext(), WorkoutFeed.class));
            }
        });

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*finish();*/
                startActivity(new Intent(getApplicationContext(), MainWatch.class));
            }
        });

        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*finish();*/
                startActivity(new Intent(getApplicationContext(), BMIActivity.class));
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MusicActivity.class));
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReadDBActivity.class));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SettingActivity.class));
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(FeedActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        });


    }

    @Override
    public void onBackPressed() {
        if(true){
            return;
        }
        else{
            super.onBackPressed();
        }
    }

    private Flashbar displayQuote() {
        return new Flashbar.Builder(this)
                .gravity(Flashbar.Gravity.BOTTOM)
                .title("Quote of the Day!")
                .message("This is very deep. \n -MLK")
                .backgroundDrawable(R.drawable.bg_gradient)
                .enableSwipeToDismiss()
                .build();
    }
}
