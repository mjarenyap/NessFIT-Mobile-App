package mobapde.machineproject.thenessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AddToRoutineActivity extends AppCompatActivity {

    ImageView backButton;
    TextView dayTitle;
    Button cardioCategory, armsCategory, torsoCategory, legCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_routine);

        //initialize the required variables
        backButton = (ImageView) findViewById(R.id.iv_back);
        dayTitle = (TextView) findViewById(R.id.tv_day);
        cardioCategory = (Button) findViewById(R.id.bt_cardio);
        armsCategory = (Button) findViewById(R.id.bt_arms);
        torsoCategory = (Button) findViewById(R.id.bt_torso);
        legCategory = (Button) findViewById(R.id.bt_legs);

        //todo update the dsiplay for the day title

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        cardioCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fetch the cardio category exercises
            }
        });

        armsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fetch the arms category exercises
            }
        });

        torsoCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fetch the torso category exercises
            }
        });

        legCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fetch the legs category exercises
            }
        });
    }
}

// The page is similar to the exercise list page
// Users can add an exercise into a routine