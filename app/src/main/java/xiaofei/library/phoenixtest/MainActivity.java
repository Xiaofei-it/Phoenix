package xiaofei.library.phoenixtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.lang.reflect.GenericSignatureFormatError;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Int", 5);
                startActivity(intent);
            }
        });
        BlankFragment fragment = BlankFragment.newInstance("s1", "s2");
        Gson gson = new Gson();
        //Log.v("Eric", "Fragment = " + gson.toJson(fragment));
        //Log.v("Eric", "Activity = " + gson.toJson(this)); // block
        //Log.v("Eric", "Class = " + gson.toJson(MainActivity.class)); // throw an exception:  Forgot to register a type adapter?

    }
}
