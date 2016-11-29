package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ByteArrayBundleVisitor implements BundleVisitor {

    static final ByteArrayBundleVisitor INSTANCE = new ByteArrayBundleVisitor();

    private ByteArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putByteArray(key, (byte[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getByteArray(key);
    }
}
