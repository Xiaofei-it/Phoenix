package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class IntArrayBundleVisitor implements BundleVisitor {

    static final IntArrayBundleVisitor INSTANCE = new IntArrayBundleVisitor();

    private IntArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putIntArray(key, (int[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getIntArray(key);
    }
}
