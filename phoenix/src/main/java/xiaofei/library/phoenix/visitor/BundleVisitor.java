package xiaofei.library.phoenix.visitor;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Xiaofei on 16/11/25.
 */

public interface BundleVisitor {

    void put(Bundle bundle, String key, Object value);

    Object get(Bundle bundle, String key);

}
