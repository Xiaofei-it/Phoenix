package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class CharSequenceBundleVisitor implements BundleVisitor {

    static final CharSequenceBundleVisitor INSTANCE = new CharSequenceBundleVisitor();

    private CharSequenceBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putCharSequence(key, (CharSequence) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getCharSequence(key);
    }
}
