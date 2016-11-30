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
import android.text.TextUtils;

import xiaofei.library.phoenix.Phoenix;
import xiaofei.library.phoenix.Utils;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ObjectBundleVisitor implements BundleVisitor {

    static final ObjectBundleVisitor INSTANCE = new ObjectBundleVisitor();

    private ObjectBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            Bundle tmp = new Bundle();
            Phoenix.saveInstance(value, tmp);
            tmp.putString("ClassName", value.getClass().getName());
            bundle.putBundle(key, tmp);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        Bundle tmp = bundle.getBundle(key);
        if (tmp == null) {
            return null;
        }
        String className = bundle.getString("ClassName");
        if (TextUtils.isEmpty(className)) {
            return null;
        }
        try {
            Class<?> clazz = Class.forName(className);
            Object instance = Utils.newInstance(clazz);
            Phoenix.restoreInstance(instance, tmp);
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
