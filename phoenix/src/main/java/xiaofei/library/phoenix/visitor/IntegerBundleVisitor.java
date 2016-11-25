package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Eric on 16/11/25.
 */

class IntegerBundleVisitor implements BundleVisitor {

    static final IntegerBundleVisitor INSTANCE = new IntegerBundleVisitor();

    private IntegerBundleVisitor() {}
    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putInt(key, (Integer) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getInt(key, 0);
    }
}
