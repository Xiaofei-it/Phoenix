package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class DoubleArrayBundleVisitor implements BundleVisitor {

    static final DoubleArrayBundleVisitor INSTANCE = new DoubleArrayBundleVisitor();

    private DoubleArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putDoubleArray(key, (double[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getDoubleArray(key);
    }
}
