package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class FloatBundleVisitor implements BundleVisitor {

    static final FloatBundleVisitor INSTANCE = new FloatBundleVisitor();

    private FloatBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putFloat(key, (Float) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getFloat(key);
    }
}
