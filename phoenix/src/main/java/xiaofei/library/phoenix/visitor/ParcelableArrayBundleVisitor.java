package xiaofei.library.phoenix.visitor;

import android.os.Bundle;
import android.os.Parcelable;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ParcelableArrayBundleVisitor implements BundleVisitor {

    static final ParcelableArrayBundleVisitor INSTANCE = new ParcelableArrayBundleVisitor();

    private ParcelableArrayBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putParcelableArray(key, (Parcelable[]) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getParcelableArray(key);
    }
}
