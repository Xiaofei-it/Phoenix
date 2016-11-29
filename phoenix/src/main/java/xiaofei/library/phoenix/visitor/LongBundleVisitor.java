package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class LongBundleVisitor implements BundleVisitor {

    static final LongBundleVisitor INSTANCE = new LongBundleVisitor();

    private LongBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putLong(key, (Long) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getLong(key);
    }
}
