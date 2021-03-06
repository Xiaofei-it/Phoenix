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

import android.os.Bundle;
import android.os.Parcelable;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ParcelableArrayBundleVisitor implements BundleVisitor {

    static final ParcelableArrayBundleVisitor INSTANCE = new ParcelableArrayBundleVisitor();

    private ParcelableArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putParcelableArray(key, (Parcelable[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getParcelableArray(key);
    }
}
