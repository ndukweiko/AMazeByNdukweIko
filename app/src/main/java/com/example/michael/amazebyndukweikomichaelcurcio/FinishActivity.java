package com.example.michael.amazebyndukweikomichaelcurcio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class FinishActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_finish);
        initializeVariables();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToTitleScreen();
            }
        });
    }

    /**
     * kicks it back to the title screen, called when the user clicks the back
     * button
     */
    private void switchToTitleScreen(){
        Intent i = new Intent(this, AMazeActivity.class);
        startActivity(i);
    }

    /**
     * initializes the back button (as it is the only variable in need of
     * initialization in this activity)
     */
  private void initializeVariables(){
      button = (Button) findViewById(R.id.button);
  }
}
