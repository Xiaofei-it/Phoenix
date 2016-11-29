package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

public interface BundleVisitor {

    void put(Bundle bundle, String key, Object value);

    Object get(Bundle bundle, String key);

}
