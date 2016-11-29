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

/**
 * Created by Xiaofei on 16/11/29.
 */

class SupportFragmentArrayBundleVisitor extends ArrayBundleVisitor<Fragment> {

    private FragmentBundleVisitor mBundleVisitor;

    SupportFragmentArrayBundleVisitor(Activity activity) {
        mBundleVisitor = new FragmentBundleVisitor(activity);
    }

    @Override
    Fragment getFromBundle(Bundle bundle, String key) {
        return (Fragment) mBundleVisitor.get(bundle, key);
    }

    @Override
    void putIntoBundle(Bundle bundle, String key, Object object) {
        mBundleVisitor.put(bundle, key, object);
    }
}
