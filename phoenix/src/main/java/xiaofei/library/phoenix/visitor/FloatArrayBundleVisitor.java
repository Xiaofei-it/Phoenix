package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class FloatArrayBundleVisitor implements BundleVisitor {

    static final FloatArrayBundleVisitor INSTANCE = new FloatArrayBundleVisitor();

    private FloatArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putFloatArray(key, (float[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getFloatArray(key);
    }
}
