package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ByteBundleVisitor implements BundleVisitor {

    static final ByteBundleVisitor INSTANCE = new ByteBundleVisitor();

    private ByteBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putByte(key, (Byte) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getByte(key);
    }
}
