import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yourjourney.CharCreate;
import com.example.yourjourney.R;

public class MainActivity extends AppCompatActivity {

    public TextView title;
    public Button start_btn;
    public Button load_btn;
    public Button exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start(View v) {
        Intent startSwitch = new Intent(getApplicationContext(), CharCreate.class);
        startActivity(startSwitch);
    }

    public void load(View v) {
        Intent loadSwitch = new Intent(getApplicationContext(), CharCreate.class);
        startActivity(loadSwitch);
    }

    public void exit(View v) {
        System.exit(0);
    }
}