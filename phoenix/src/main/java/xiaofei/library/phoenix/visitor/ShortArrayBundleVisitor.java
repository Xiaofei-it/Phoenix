package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ShortArrayBundleVisitor implements BundleVisitor {

    static final ShortArrayBundleVisitor INSTANCE = new ShortArrayBundleVisitor();

    private ShortArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putShortArray(key, (short[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getShortArray(key);
    }
}
