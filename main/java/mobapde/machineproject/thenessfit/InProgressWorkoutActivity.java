package mobapde.machineproject.thenessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InProgressWorkoutActivity extends AppCompatActivity {

    ImageView backButton, startButton;
    Button finishWorkoutButton;
    TextView exerciseName, calorieBurn;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_progress_workout);

        //initialize the required variables
        backButton = (ImageView) findViewById(R.id.iv_back);
        startButton = (ImageView) findViewById(R.id.iv_start_button);
        finishWorkoutButton = (Button) findViewById(R.id.bt_finish_workout);
        nextButton = (Button) findViewById(R.id.bt_next_exercise);
        exerciseName = (TextView) findViewById(R.id.tv_exercise_name);
        calorieBurn = (TextView) findViewById(R.id.tv_calorie_burn_count);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if there is a previous exercise
                finish();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start the timer
                //change into pause button
            }
        });

        finishWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
