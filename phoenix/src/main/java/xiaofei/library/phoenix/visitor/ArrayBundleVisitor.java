package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Xiaofei on 16/11/25.
 */

abstract class ArrayBundleVisitor<T> implements BundleVisitor {

    private static final String KEY_LENGTH = "length";

    private Class<T> getComponentType() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    abstract void putIntoBundle(Bundle bundle, String key, Object object);

    abstract T getFromBundle(Bundle bundle, String key);

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            Bundle tmp = new Bundle();
            int length = Array.getLength(value);
            tmp.putInt(KEY_LENGTH, length);
            for (int i = 0; i < length; ++i) {
                putIntoBundle(tmp, Integer.toString(i), Array.get(value, i));
            }
            bundle.putBundle(key, tmp);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        int length = bundle.getInt(KEY_LENGTH);
        Object array = Array.newInstance(getComponentType(), length);
        for (int i = 0; i < length; ++i) {
            Object o = getFromBundle(bundle, String.valueOf(i));
            Array.set(array, i, o);
        }
        return array;
    }
}
