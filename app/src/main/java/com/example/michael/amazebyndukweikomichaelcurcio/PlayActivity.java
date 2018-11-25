package com.example.michael.amazebyndukweikomichaelcurcio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.util.Log;
import android.widget.Toast;
import android.widget.ProgressBar;

public class PlayActivity extends AppCompatActivity {
    private static Button playbutton;
    private static Button toggleButton;
    private static Button toggleButton2;
    private static Button toggleButton3;
    private static ProgressBar progressBar;
    private static  String method;
    private static String drive;
    private Button upButton;
    private Button backButton;
    private Button leftButton;
    private Button rightButton;
    private Button pause;
    private Button toTitle;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_play);
        show_maze();
        show_solution();
        show_walls();
        progressBar();
        intent = getIntent();

     String m = intent.getStringExtra("method");
        String d = intent.getStringExtra("drive");
        upButton = (Button) findViewById(R.id.button2);

        backButton = (Button) findViewById(R.id.button5);
        leftButton = (Button) findViewById(R.id.button3);
        rightButton = (Button) findViewById(R.id.button4);
        toTitle = (Button)findViewById(R.id.button6);
        pause = (Button)findViewById(R.id.button7);

        if(d.equalsIgnoreCase("Manual") ){
            upButton.setVisibility(View.VISIBLE);
            leftButton.setVisibility(View.VISIBLE);
            rightButton.setVisibility(View.VISIBLE);
            backButton.setVisibility(View.VISIBLE);
        }
        else if(!d.equalsIgnoreCase("Manual")){
            pause.setVisibility(View.VISIBLE);

        }

        genButtons();
    }

    /**
     * Call this to kick it to the finish screen of the maze, will generally be called
     * when the robot runs out of battery or when the user beats the maze.
     * @param v
     */
    public void generate_finish(View v){
        Intent intent = new Intent(this, FinishActivity.class);
        startActivity(intent);
    }

    /**
     * initializes the play button.
     */
    public void gogobutton(){
        playbutton = (Button)findViewById(R.id.playbutton);
        playbutton.setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        generate_finish(view);
                    }


                }
        );
    }

    /**
     * initializes the toggle button which allows the user to see the maze from a top-down
     * perspective
     */
    public void show_maze(){
        toggleButton = (Button) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view){
                        if (pressed == 0) {
                            Log.v("OnClickListener", "display Maze");
                            Toast.makeText(getBaseContext(), "displaying Maze", Toast.LENGTH_SHORT).show();
                            pressed = 1;
                        }
                        else{
                            Log.v("OnClickListener", "stopped display Maze");
                            Toast.makeText(getBaseContext(), "stopped displaying Maze", Toast.LENGTH_SHORT).show();
                            pressed = 0;
                        }
                    }
                }
        );
    }

    /**
     * initializes and provides functionality to the toggle button which shows
     * the user the solution to the maze on the overhead map.
     */
    public void show_solution(){
        toggleButton2 = (Button) findViewById(R.id.toggleButton2);
        toggleButton2.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view){
                        if (pressed == 0) {
                            Log.v("OnClickListener", "display Solution");
                            Toast.makeText(getBaseContext(), "displaying Solution", Toast.LENGTH_SHORT).show();
                            pressed = 1;
                        }
                        else{
                            Log.v("OnClickListener", "stopped displaying Solution");
                            Toast.makeText(getBaseContext(), "stopped displaying Solution", Toast.LENGTH_SHORT).show();
                            pressed = 0;
                        }
                    }
                }
        );
    }

    /**
     * initializes and provides functionality to the toggle button which allows the user
     * to indicate whether or not they only want to see visible walls on the overhead map.
     */
    public void show_walls(){
        toggleButton3 = (Button) findViewById(R.id.toggleButton3);
        toggleButton3.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view){
                        if (pressed == 0) {
                            Log.v("OnClickListener", "display Visible Walls");
                            Toast.makeText(getBaseContext(), "displaying Visible Walls", Toast.LENGTH_SHORT).show();
                            pressed = 1;
                        }
                        else{
                            Log.v("OnClickListener", "stopped display Visible Walls");
                            Toast.makeText(getBaseContext(), "stopped displaying Visible Walls", Toast.LENGTH_SHORT).show();
                            pressed = 0;
                        }
                    }
                }
        );
    }

    /**
     * initializes the progress bar
     */
    public void progressBar(){
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar.setMax(2500);
        progressBar.setProgress(progressBar.getMax());

    }

    /**
     * initializes and provids functionality to the buttons which allow the
     * user to control which direction the rpbot.
     */
    public void genButtons(){




        upButton.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view) {
                    }
                 });

        backButton.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view) {
                    }
                });

        leftButton.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view) {
                    }
                });

        rightButton.setOnClickListener(
                new OnClickListener(){
                    int pressed = 0;
                    @Override
                    public void onClick(View view) {
                    }
                });

    }
}
