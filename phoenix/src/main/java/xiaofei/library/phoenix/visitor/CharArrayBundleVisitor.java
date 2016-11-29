package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class CharArrayBundleVisitor implements BundleVisitor {

    static final CharArrayBundleVisitor INSTANCE = new CharArrayBundleVisitor();

    private CharArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putCharArray(key, (char[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getCharArray(key);
    }
}
