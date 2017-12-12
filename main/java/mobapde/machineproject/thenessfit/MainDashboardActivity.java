package mobapde.machineproject.thenessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainDashboardActivity extends AppCompatActivity {

    ImageView navIcon, settingsIcon;
    TextView dateToday, durationCount, exerciseCount, calorieCount;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        //initialize the required variables
        navIcon = (ImageView) findViewById(R.id.iv_hamburger);
        settingsIcon = (ImageView) findViewById(R.id.iv_settings);
        dateToday = (TextView) findViewById(R.id.tv_date);
        durationCount = (TextView) findViewById(R.id.tv_duration_count);
        exerciseCount = (TextView) findViewById(R.id.tv_exercise_count);
        calorieCount = (TextView) findViewById(R.id.tv_calorie_burn_count);
        startButton = (Button) findViewById(R.id.bt_start);

        navIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show navigation drawer
            }
        });

        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to settings page
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to in progress page
            }
        });
    }
}
