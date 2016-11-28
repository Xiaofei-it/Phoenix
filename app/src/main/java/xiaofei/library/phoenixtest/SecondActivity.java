package xiaofei.library.phoenixtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Eric", "si = " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        setIntent(null);
        Intent intent1 = getIntent();
        StringBuilder sb = new StringBuilder();
        sb.append("intent = " + intent + " intent1 = " + intent1);
        if (intent != null) {
            sb.append(" Int = ").append(intent.getIntExtra("Int", -1));
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
        findViewById(R.id.b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
