package xiaofei.library.phoenixtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

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
        final Fragment fragment = BlankFragment.newInstance("s1", "s2");
        getSupportFragmentManager().beginTransaction().add(fragment, "Fuck").commit();
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(BlankFragment.class, new TypeAdapter<Object>() {
                    @Override
                    public Object read(JsonReader in) throws IOException {
                        String tag = in.nextString();
                        return MainActivity.this.getSupportFragmentManager().findFragmentByTag(tag);
                    }

                    @Override
                    public void write(JsonWriter out, Object value) throws IOException {
                        out.value(((Fragment)value).getTag());
                    }
                })
                .registerTypeAdapter(Fragment.class,  new TypeAdapter<Object>() {
                    @Override
                    public Object read(JsonReader in) throws IOException {
                        String tag = in.nextString();
                        return MainActivity.this.getSupportFragmentManager().findFragmentByTag(tag);
                    }

                    @Override
                    public void write(JsonWriter out, Object value) throws IOException {
                        out.value(((Fragment)value).getTag());
                    }
                })

//                .registerTypeAdapter(BlankFragment.class, new TypeAdapter<BlankFragment>() {
//                    @Override
//                    public BlankFragment read(JsonReader in) throws IOException {
//                        String tag = in.nextString();
//                        return (BlankFragment) MainActivity.this.getSupportFragmentManager().findFragmentByTag(tag);
//                    }
//
//                    @Override
//                    public void write(JsonWriter out, BlankFragment value) throws IOException {
//                        out.value(value.getTag());
//                    }
//                })
//
                .create();
        try {
            Log.v("Eric", "Fragment = " + gson.toJson(fragment));
        } catch (RuntimeException e) {
            Log.e("Eric", "Error", e);
        }
        //Log.v("Eric", "Activity = " + gson.toJson(this)); // block
        //Log.v("Eric", "Class = " + gson.toJson(MainActivity.class)); // throw an exception:  Forgot to register a type adapter?

    }
}
