package xiaofei.library.phoenix.visitor;

import android.os.Bundle;

import java.util.HashMap;

/**
 * Created by Xiaofei on 16/11/25.
 */

public interface BundleVisitor {
    void put(Bundle bundle, String key, Object value);

    Object get(Bundle bundle, String key);

    HashMap<Class<?>, BundleVisitor> MAP = new HashMap<Class<?>, BundleVisitor>() {
        {
            put(Integer.class, IntegerBundleVisitor.INSTANCE);
            put(int.class, IntegerBundleVisitor.INSTANCE);
        }
    };

    class BundleVisitorFactory {
        public static BundleVisitor getBundleVisitor(Class<?> clazz) {
            return MAP.get(clazz);
        }
    }
}
