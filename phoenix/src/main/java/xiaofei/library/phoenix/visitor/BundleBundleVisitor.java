package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class BundleBundleVisitor implements BundleVisitor {

    static final BundleBundleVisitor INSTANCE = new BundleBundleVisitor();

    private BundleBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putBundle(key, (Bundle) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getBundle(key);
    }
}
