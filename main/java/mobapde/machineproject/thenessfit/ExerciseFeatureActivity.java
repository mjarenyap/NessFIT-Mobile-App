package mobapde.machineproject.thenessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseFeatureActivity extends AppCompatActivity {

    ImageView backButton, startButton;
    Button deleteButton;
    TextView exerciseName, exerciseDescription, calorieBurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_feature);

        //initialize the required variables
        backButton = (ImageView) findViewById(R.id.iv_back);
        startButton = (ImageView) findViewById(R.id.iv_start_button);
        deleteButton = (Button) findViewById(R.id.bt_delete);
        exerciseName = (TextView) findViewById(R.id.tv_exercise_name);
        exerciseDescription = (TextView) findViewById(R.id.tv_exercise_description);
        calorieBurn = (TextView) findViewById(R.id.tv_calorie_burn_count);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start the timer
                //change the image resource to a pause button
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete this current exercise
            }
        });

        //if it is a custom exercise, set the onClickListener of the delete button
    }
}

// Displays the how-to photo, title, description and calorie burn of the exercise
// If it's a custom, user must be able to delete that exercise