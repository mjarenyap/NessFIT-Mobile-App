package mobapde.machineproject.thenessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RoutinesActivity extends AppCompatActivity {

    ImageView backButton;
    TextView dayRoutine, addButton;
    TextView duration_count, exercise_count, calorie_count;
    RecyclerView exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routines);

        backButton = (ImageView) findViewById(R.id.iv_back);
        dayRoutine = (TextView) findViewById(R.id.tv_day_routine);
        addButton = (TextView) findViewById(R.id.tv_add);
        duration_count = (TextView) findViewById(R.id.tv_duration_count);
        exercise_count = (TextView) findViewById(R.id.tv_exercise_count);
        calorie_count = (TextView) findViewById(R.id.tv_calorie_burn_count);
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
                //go to the add-to-routine page
                Intent i = new Intent();
                i.setClass(getBaseContext(), AddToRoutineActivity.class);
                startActivityForResult(i, 0);
            }
        });

        //todo add result handler
    }
}
