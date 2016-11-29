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

/**
 * Created by Xiaofei on 16/11/25.
 */

class LongBundleVisitor implements BundleVisitor {

    static final LongBundleVisitor INSTANCE = new LongBundleVisitor();

    private LongBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putLong(key, (Long) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getLong(key);
    }
}
