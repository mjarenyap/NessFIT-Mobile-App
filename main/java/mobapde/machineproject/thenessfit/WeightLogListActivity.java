package mobapde.machineproject.thenessfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class WeightLogListActivity extends AppCompatActivity {

    ImageView backButton;
    TextView addButton;
    RecyclerView weighlogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_log_list);

        backButton = (ImageView) findViewById(R.id.iv_back);
        addButton = (TextView) findViewById(R.id.tv_add);
        weighlogList = (RecyclerView) findViewById(R.id.rv_weightlog);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to weight log page
                Intent i = new Intent();
                i.setClass(getBaseContext(), WeightLogActivity.class);
                i.putExtra("toAddNew", true);
                startActivity(i);
            }
        });
    }
}
