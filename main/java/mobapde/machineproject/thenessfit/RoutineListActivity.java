package mobapde.machineproject.thenessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RoutineListActivity extends AppCompatActivity {

    LinearLayout sunday, monday, tuesday, wednesday, thursday, friday, saturday;
    TextView sun_count, mon_count, tues_count, wed_count, thurs_count, fri_count, sat_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine_list);

        //initialize the required variables
        sunday = (LinearLayout) findViewById(R.id.sunday_routine);
        monday = (LinearLayout) findViewById(R.id.monday_routine);
        tuesday = (LinearLayout) findViewById(R.id.tuesday_routine);
        wednesday = (LinearLayout) findViewById(R.id.wednesday_routine);
        thursday = (LinearLayout) findViewById(R.id.thursday_routine);
        friday = (LinearLayout) findViewById(R.id.friday_routine);
        saturday = (LinearLayout) findViewById(R.id.saturday_routine);

        sun_count = (TextView) findViewById(R.id.tv_sun);
        mon_count = (TextView) findViewById(R.id.tv_mon);
        tues_count = (TextView) findViewById(R.id.tv_tues);
        wed_count = (TextView) findViewById(R.id.tv_wed);
        thurs_count = (TextView) findViewById(R.id.tv_thurs);
        fri_count = (TextView) findViewById(R.id.tv_fri);
        sat_count = (TextView) findViewById(R.id.tv_sat);

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 1);

                startActivity(i);
            }
        });

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 2);

                startActivity(i);
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 3);

                startActivity(i);
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 4);

                startActivity(i);
            }
        });

        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 5);

                startActivity(i);
            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 6);

                startActivity(i);
            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to routines page
                Intent i = new Intent();
                i.setClass(getBaseContext(), RoutinesActivity.class);
                i.putExtra("day", 7);

                startActivity(i);
            }
        });

        //calculate the numbers for duration, exercises and calorie burns
    }
}
