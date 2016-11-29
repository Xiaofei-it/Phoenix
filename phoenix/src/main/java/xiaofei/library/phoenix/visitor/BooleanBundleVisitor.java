package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class BooleanBundleVisitor implements BundleVisitor {

    static final BooleanBundleVisitor INSTANCE = new BooleanBundleVisitor();

    private BooleanBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putBoolean(key, (Boolean) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getBoolean(key);
    }
}
