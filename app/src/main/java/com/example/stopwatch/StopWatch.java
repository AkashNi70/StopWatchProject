package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {

    Button btnStart,btnStop;
    Animation roundingalone;
    ImageView icanchor;
    Chronometer timeHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_stop_watch );

        btnStart = (Button)findViewById( R.id.btnStart );
        btnStop = (Button)findViewById( R.id.btnStop );
        icanchor = (ImageView)findViewById( R.id.icanchor );
        timeHere = (Chronometer)findViewById( R.id.timerHere );

        btnStop.setAlpha( 0 );

        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone );

        Typeface MMedium = Typeface.createFromAsset( getAssets(),"fonts/MMedium.ttf" );

        btnStart.setTypeface( MMedium );
        btnStop.setTypeface( MMedium );

        btnStart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                icanchor.startAnimation( roundingalone );
                btnStop.animate().alpha( 1 ).translationY( -80 ).setDuration( 300 ).start();
                btnStart.animate().alpha( 0 ).setDuration( 300 ).start();

                timeHere.setBase( SystemClock.elapsedRealtime() );
                timeHere.start();
            }
        } );
    }
}
