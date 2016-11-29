package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class CharacterBundleVisitor implements BundleVisitor {

    static final CharacterBundleVisitor INSTANCE = new CharacterBundleVisitor();

    private CharacterBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putChar(key, (Character) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getChar(key);
    }
}
