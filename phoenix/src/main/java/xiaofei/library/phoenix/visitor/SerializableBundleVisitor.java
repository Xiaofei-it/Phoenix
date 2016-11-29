package xiaofei.library.phoenix.visitor;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Xiaofei on 16/11/25.
 */

class SerializableBundleVisitor implements BundleVisitor {

    static final SerializableBundleVisitor INSTANCE = new SerializableBundleVisitor();

    private SerializableBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putSerializable(key, (Serializable) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getSerializable(key);
    }
}
