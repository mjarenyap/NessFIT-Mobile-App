package mobapde.machineproject.thenessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseListActivity extends AppCompatActivity {

    ImageView backButton;
    TextView addButton;
    Button cardioCategory, armsCategory, torsoCategory, legCategory;
    RecyclerView exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        //initialize the required variables
        backButton = (ImageView) findViewById(R.id.iv_back);
        addButton = (TextView) findViewById(R.id.tv_add);
        cardioCategory = (Button) findViewById(R.id.bt_cardio);
        armsCategory = (Button) findViewById(R.id.bt_arms);
        torsoCategory = (Button) findViewById(R.id.bt_torso);
        legCategory = (Button) findViewById(R.id.bt_legs);
        exerciseList = (RecyclerView) findViewById(R.id.rv_exercise);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getBaseContext(), CreateExerciseActivity.class);
                startActivity(i);
            }
        });

        cardioCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fetch cardio category exercises
            }
        });

        armsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fetch arms category exercises
            }
        });

        torsoCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fetch torso category exercises
            }
        });

        legCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fetch legs category exercises
            }
        });
    }
}

// Displays a list of exercises falling under different categories