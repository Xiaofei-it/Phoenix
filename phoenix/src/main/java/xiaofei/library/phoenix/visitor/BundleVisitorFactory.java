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
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Xiaofei on 16/11/29.
 */
public class BundleVisitorFactory {

    private static final HashMap<Class<?>, BundleVisitor> MAP = new HashMap<Class<?>, BundleVisitor>() {
        {
            // boolean, byte, char, short, int, long, float, and double.
            put(Integer.class, IntegerBundleVisitor.INSTANCE);
            put(int.class, IntegerBundleVisitor.INSTANCE);
            put(Float.class, FloatBundleVisitor.INSTANCE);
            put(float.class, FloatBundleVisitor.INSTANCE);
            put(Double.class, DoubleBundleVisitor.INSTANCE);
            put(double.class, DoubleBundleVisitor.INSTANCE);
            put(Boolean.class, BooleanBundleVisitor.INSTANCE);
            put(boolean.class, BooleanBundleVisitor.INSTANCE);
            put(Character.class, CharacterBundleVisitor.INSTANCE);
            put(char.class, CharacterBundleVisitor.INSTANCE);
            put(Byte.class, ByteBundleVisitor.INSTANCE);
            put(byte.class, ByteBundleVisitor.INSTANCE);
            put(Long.class, LongBundleVisitor.INSTANCE);
            put(long.class, LongBundleVisitor.INSTANCE);
            put(Short.class, ShortBundleVisitor.INSTANCE);
            put(short.class, ShortBundleVisitor.INSTANCE);

            // Byte[]???
            put(byte[].class, ByteArrayBundleVisitor.INSTANCE);
            put(char[].class, CharArrayBundleVisitor.INSTANCE);
            put(int[].class, IntArrayBundleVisitor.INSTANCE);
            put(float[].class, FloatArrayBundleVisitor.INSTANCE);
            put(short[].class, ShortArrayBundleVisitor.INSTANCE);
            put(boolean[].class, BooleanArrayBundleVisitor.INSTANCE);
            put(double[].class, DoubleArrayBundleVisitor.INSTANCE);
            put(long[].class, LongArrayBundleVisitor.INSTANCE);

            put(String.class, StringBundleVisitor.INSTANCE);
            put(String[].class, StringArrayBundleVisitor.INSTANCE);
        }
    };

    private static BundleVisitor getBundleVisitorInternal(Class<?> clazz) {
        BundleVisitor bundleVisitor = MAP.get(clazz);
        if (bundleVisitor != null) {
            return bundleVisitor;
        }
        if (Bundle.class.isAssignableFrom(clazz)) {
            return BundleBundleVisitor.INSTANCE;
        }
        if (Parcelable.class.isAssignableFrom(clazz)) {
            return ParcelableBundleVisitor.INSTANCE;
        }
        if (Serializable.class.isAssignableFrom(clazz)) {
            return SerializableBundleVisitor.INSTANCE;
        }
        if (CharSequence.class.isAssignableFrom(clazz)) {
            return CharSequenceBundleVisitor.INSTANCE;
        }
        return MAP.get(clazz);
    }

    private static BundleVisitor getBundleVisitorForActivity(Activity activity, Class<?> clazz) {
        if (android.app.Fragment.class.isAssignableFrom(clazz)) {
            return new FragmentBundleVisitor(activity);
        }
        if (android.support.v4.app.Fragment.class.isAssignableFrom(clazz)) {
            return new SupportFragmentBundleVisitor(activity);
        }
        return getBundleVisitorInternal(clazz);
    }

    public static BundleVisitor getBundleVisitor(Object instance, Class<?> clazz) {
        return instance instanceof Activity ? getBundleVisitorForActivity((Activity) instance, clazz)
                : getBundleVisitorInternal(clazz);
    }
}
