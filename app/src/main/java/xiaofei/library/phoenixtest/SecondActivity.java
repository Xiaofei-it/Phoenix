package xiaofei.library.phoenixtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        StringBuilder sb = new StringBuilder();
        sb.append("intent = " + intent);
        if (intent != null) {
            sb.append(" Int = ").append(intent.getIntExtra("Int", -1));
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }
}
