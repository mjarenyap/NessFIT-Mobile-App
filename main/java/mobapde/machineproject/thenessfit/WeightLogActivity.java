package mobapde.machineproject.thenessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class WeightLogActivity extends AppCompatActivity {

    DatabaseHelper db;
    ImageView backButton;
    EditText inputWeight;
    Button saveButton;
    Button deleteButton;
    boolean toAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_log);

        db = new DatabaseHelper(getBaseContext());

        //initialize the elements
        backButton = (ImageView) findViewById(R.id.iv_back);
        inputWeight = (EditText) findViewById(R.id.et_weight);
        saveButton = (Button) findViewById(R.id.bt_save);
        deleteButton = (Button) findViewById(R.id.bt_delete);

        toAddNew = (boolean)getIntent().getExtras().getBoolean("toAddNew");
        if(toAddNew)
            deleteButton.setText("CANCEL");

        else deleteButton.setText("DELETE");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float new_weight = Float.parseFloat(inputWeight.getText().toString());
                //get current day, month and year
                //store it in the database
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!toAddNew){
                    long currID = getIntent().getExtras().getLong("currID");
                    boolean deleteFlag = db.deleteWeightLog(currID);

                    if(deleteFlag)
                        finish();
                }

                else finish();
            }
        });
    }
}
