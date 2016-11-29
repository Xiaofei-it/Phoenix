package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class BooleanArrayBundleVisitor implements BundleVisitor {

    static final BooleanArrayBundleVisitor INSTANCE = new BooleanArrayBundleVisitor();

    private BooleanArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putBooleanArray(key, (boolean[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getBooleanArray(key);
    }
}
