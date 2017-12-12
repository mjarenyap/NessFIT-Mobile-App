package mobapde.machineproject.thenessfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CreateExerciseActivity extends AppCompatActivity {

    ImageView backButton;
    Button addButton, saveButton;
    EditText inputTitle, inputDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);

        //initialize the required variables
        backButton = (ImageView) findViewById(R.id.iv_back);
        addButton = (Button) findViewById(R.id.bt_add_photo);
        inputTitle = (EditText) findViewById(R.id.et_name_exercise);
        inputDescription = (EditText) findViewById(R.id.et_desc_exercise);


        //set the onClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intents for the gallery
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputTitle.getText().toString();
                String description = inputDescription.getText().toString();
            }
        });

        //set the onCLickListener for the save button
            //get the photo from the container
            //if no photo was uploaded, set the default photo
            //get the value of the title EditText
            //get the value of the description EditText
            //add the new exercise into the database
    }
}

//Can add a photo, title and description of an exercise