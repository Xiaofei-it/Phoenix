package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class StringBundleVisitor implements BundleVisitor {

    static final StringBundleVisitor INSTANCE = new StringBundleVisitor();

    private StringBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putString(key, (String) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getString(key);
    }
}
