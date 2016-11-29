/**
 *
 * Copyright 2016 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
            Fragment[] fragments = new Fragment[]{fragment, fragment};
            Log.v("Eric", "Fragment = " + gson.toJson(fragments));
            // Read every Fragment!
        } catch (RuntimeException e) {
            Log.e("Eric", "Error", e);
        }
        //Log.v("Eric", "Activity = " + gson.toJson(this)); // block
        //Log.v("Eric", "Class = " + gson.toJson(MainActivity.class)); // throw an exception:  Forgot to register a type adapter?

    }
}
