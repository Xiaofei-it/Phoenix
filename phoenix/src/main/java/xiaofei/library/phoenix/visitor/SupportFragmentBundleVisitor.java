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

package xiaofei.library.phoenix.visitor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Xiaofei on 16/11/25.
 */

class SupportFragmentBundleVisitor implements BundleVisitor {

    private WeakReference<Activity> mRef;

    SupportFragmentBundleVisitor(Activity activity) {
        mRef = new WeakReference<Activity>(activity);
    }

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putString(key, ((Fragment) value).getTag());
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        Activity activity = mRef.get();
        if (activity instanceof FragmentActivity) {
            return ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(bundle.getString(key));
        }
        return null;
    }
}
