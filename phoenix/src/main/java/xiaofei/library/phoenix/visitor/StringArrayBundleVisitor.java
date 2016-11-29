package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class StringArrayBundleVisitor implements BundleVisitor {

    static final StringArrayBundleVisitor INSTANCE = new StringArrayBundleVisitor();

    private StringArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putStringArray(key, (String[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getStringArray(key);
    }
}
