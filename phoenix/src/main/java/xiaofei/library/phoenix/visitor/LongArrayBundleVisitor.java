package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class LongArrayBundleVisitor implements BundleVisitor {

    static final LongArrayBundleVisitor INSTANCE = new LongArrayBundleVisitor();

    private LongArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putLongArray(key, (long[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getLongArray(key);
    }
}
