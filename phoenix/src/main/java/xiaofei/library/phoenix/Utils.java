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

package xiaofei.library.phoenix;


import android.os.Bundle;

import java.lang.reflect.Field;
import java.util.HashSet;

import xiaofei.library.phoenix.visitor.BundleVisitor;
import xiaofei.library.phoenix.visitor.BundleVisitorFactory;


/**
 * Created by Xiaofei on 16/11/25.
 */

class Utils {

    private static final HashSet<Class<?>> BASE_CLASSES = new HashSet<Class<?>>() {
        {
            add(android.app.Fragment.class);
            add(android.support.v4.app.Fragment.class);
            add(android.app.Activity.class);
            add(android.support.v7.app.AppCompatActivity.class);
            add(android.support.v4.app.FragmentActivity.class);
            add(android.view.View.class);
            add(android.view.ViewGroup.class);
        }
    };

    private Utils() {}

    private static String getKey(Class<?> clazz, Field field) {
        return clazz.getName() + "^" + field.getName();
    }

    static boolean isBaseClass(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return true;
        }
        if (clazz == Object.class) {
            return true;
        }
        if (BASE_CLASSES.contains(clazz)) {
            return true;
        }
        if (clazz.getName().startsWith("android.")) {
            return true;
        }
        return false;
    }

    private static void put(Bundle bundle, String key, Class<?> clazz, Object value) {
        BundleVisitor bundleVisitor = BundleVisitorFactory.getBundleVisitor(clazz);
        if (bundleVisitor != null) {
            bundleVisitor.put(bundle, key, value);
        }
    }

    private static Object get(Bundle bundle, String key, Class<?> clazz) {
        BundleVisitor bundleVisitor = BundleVisitorFactory.getBundleVisitor(clazz);
        if (bundleVisitor != null) {
            return bundleVisitor.get(bundle, key);
        }
        return null;
    }

    static void saveInstance(Class<?> clazz, Object instance, Bundle savedInstance) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(instance);
                put(savedInstance, getKey(clazz, field), field.getType(), value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    static void restoreInstance(Class<?> clazz, Object instance, Bundle savedInstance) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                Object value = get(savedInstance, getKey(clazz, field), field.getType());
                if (value != null) {
                    field.setAccessible(true);
                    field.set(instance, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
