package xiaofei.library.phoenix.visitor;

import android.os.Bundle;
import android.os.Parcelable;

/**
 * Created by Xiaofei on 16/11/25.
 */

class ParcelableBundleVisitor implements BundleVisitor {

    static final ParcelableBundleVisitor INSTANCE = new ParcelableBundleVisitor();

    private ParcelableBundleVisitor() {}

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putParcelable(key, (Parcelable) value);
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        return bundle.getParcelable(key);
    }
}
