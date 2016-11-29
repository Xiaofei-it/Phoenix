package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ShortBundleVisitor implements BundleVisitor {

    static final ShortBundleVisitor INSTANCE = new ShortBundleVisitor();

    private ShortBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putShort(key, (Short) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getShort(key);
    }
}
