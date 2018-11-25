package com.example.michael.amazebyndukweikomichaelcurcio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import android.content.Intent;
import android.util.Log;
public class GeneratingActivity extends AppCompatActivity {
    private int percentDone = 0;
   // private ProgressDialog progressdialog;
    private static Button back;
    private static ProgressBar progressbar;
    private static Handler handler = new Handler();
    private static boolean stop = false;
    private String method;
    private String drive;
    private Intent next_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_generating);
        Intent prev_state = getIntent();
        final String d= prev_state.getStringExtra("drive");
        final String m = prev_state.getStringExtra("method");




        makeBackButton();
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        //progressdialog = new ProgressDialog(GeneratingActivity.this);


        //this background thread allows the progress bar to artificially fill without
        // causing UI unresponsiveness
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        while (percentDone < 100 && stop == false) {

                            percentDone++;


                            handler.post(new Runnable() {

                                @Override
                                public void run() {
                                    progressbar.setProgress(percentDone);


                                }
                            });
                            try {
                                Thread.sleep(7);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                        }

                            onContinue(m,d);


                    }


                }).start();
    }


    /**
     * Method which is called once the progress bar reaches 100, passes the method and
     * explorer fields into the next activity.
     * @param m
     * @param d
     */
    public void onContinue(String m, String d){
        next_state = new Intent(this, PlayActivity.class);

        next_state.putExtra("method", m);

        next_state.putExtra("drive", d);

        startActivity(next_state);
    }

    /**
     * Supports the functionality which allows the user to click a button to
     * interrupt the maze generation and return to the title screen.
     */
    public void backToTitle(){

        Intent intent = new Intent(this, AMazeActivity.class);
        startActivity(intent);


    }

    /**
     * Initializes and gives a click listener to the button which allows the user to
     * return to the title screen.
     */
    public void makeBackButton(){
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        stop = true;

                        backToTitle();

                    }



        });
    }
}

