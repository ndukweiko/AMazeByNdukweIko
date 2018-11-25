package com.example.michael.amazebyndukweikomichaelcurcio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.widget.TextView;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AMazeActivity extends AppCompatActivity {

    private SeekBar skillLevel = null;
    private TextView textView;
    private Spinner builder;
    private Spinner driver;
    private Button explore;
    private Button revisit;
    private String drive = "Manual";
    private String method;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amaze);
        initializeVariables();

        textView.setText("Skill level: " + skillLevel.getProgress() + "/" + skillLevel.getMax());

        skillLevel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int level = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                level = progress;
            }

            @Override
            public void onStopTrackingTouch(SeekBar skillLevel){

                textView.setText("Skill level:" + skillLevel.getProgress() + "/" + skillLevel.getMax());
                Log.v("onStopTrackingTouch ", " Selected"  + skillLevel.getProgress()+ " as skill level");
                Toast.makeText(skillLevel.getContext()," Selected"  + skillLevel.getProgress()+ " as skill level, Good Choice!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                ;
            }
        });

        builder.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("builder.onItemSelected ", "Selected " + parent.getItemAtPosition(position) + " as the build method");
                Toast.makeText(builder.getContext(), "builder.onItemSelected " + "Selected " + parent.getItemAtPosition(position) + " as the build method", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        driver.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

                Log.v("driver.onItemSelected", "Selected " + parent.getItemAtPosition(position) + " as the driver method");
                Toast.makeText(driver.getContext(), "driver.onItemSelected " + "Selected " + parent.getItemAtPosition(position) + " as the driver method", Toast.LENGTH_LONG).show();
                drive = parent.getItemAtPosition(position).toString();
                Log.v(drive, "drive value");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        explore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Log.v("explore.onClick ", " Switching to generating screen");
                Toast.makeText(explore.getContext(),"explore.onClick " +  " Switching to generating screen", Toast.LENGTH_LONG ).show();
                method = "Explore";
               start_generating(v);

            }
        });

        revisit.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                Log.v("revisit.onClick ", " Switching to generating screen");
                Toast.makeText(revisit.getContext(),"revisit.onClick " +  " Switching to generating screen", Toast.LENGTH_LONG );
                method = "Revisit";
                start_generating(v);
            }
        });


        }

    /**
     * Call this method to kick it to the generating screen
     * @param view
     */
    public void start_generating(View view){
        Intent intent = new Intent(this, GeneratingActivity.class);
        if(drive != null) {
            intent.putExtra("drive", drive);
        }
        if(method != null){
            intent.putExtra("method", method);
        }

        startActivity(intent);
    }

    /**
     * This is a method to centralize the initialization of the methods
     * necessary for this activity.
     */
    private void initializeVariables(){
        skillLevel = (SeekBar) findViewById(R.id.SkillLevel);
        textView = (TextView) findViewById(R.id.TextView2);

        //initialize the builder spinner
        builder = (Spinner) findViewById(R.id.builder);
        ArrayAdapter<CharSequence> builders = ArrayAdapter.createFromResource(this, R.array.builders,
                android.R.layout.simple_spinner_item);
        builders.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        builder.setAdapter(builders);

        //initialize the driver spinner
        driver = (Spinner) findViewById(R.id.driver);
        ArrayAdapter<CharSequence> drivers = ArrayAdapter.createFromResource(this, R.array.drivers,
                android.R.layout.simple_spinner_item);
        drivers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        driver.setAdapter(drivers);

        //initialize explore button
        explore = (Button) findViewById(R.id.explore);

        //initialize revisit button
        revisit = (Button) findViewById(R.id.revisit);
    }
}
