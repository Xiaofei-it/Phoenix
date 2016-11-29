package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class DoubleBundleVisitor implements BundleVisitor {

    static final DoubleBundleVisitor INSTANCE = new DoubleBundleVisitor();

    private DoubleBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putDouble(key, (Double) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getDouble(key);
    }
}
