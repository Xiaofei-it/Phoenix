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
            // boolean, byte, char, short, int, long, float, and double.
            put(Integer.class, IntegerBundleVisitor.INSTANCE);
            put(int.class, IntegerBundleVisitor.INSTANCE);
            put(Float.class, FloatBundleVisitor.INSTANCE);
            put(float.class, FloatBundleVisitor.INSTANCE);
            put(Double.class, DoubleBundleVisitor.INSTANCE);
            put(double.class, DoubleBundleVisitor.INSTANCE);
            put(Boolean.class, BooleanBundleVisitor.INSTANCE);
            put(boolean.class, BooleanBundleVisitor.INSTANCE);
            put(Character.class, CharacterBundleVisitor.INSTANCE);
            put(char.class, CharacterBundleVisitor.INSTANCE);
            put(Byte.class, ByteBundleVisitor.INSTANCE);
            put(byte.class, ByteBundleVisitor.INSTANCE);
            put(Long.class, LongBundleVisitor.INSTANCE);
            put(long.class, LongBundleVisitor.INSTANCE);
            put(Short.class, ShortBundleVisitor.INSTANCE);
            put(short.class, ShortBundleVisitor.INSTANCE);
        }
    };

    class BundleVisitorFactory {
        public static BundleVisitor getBundleVisitor(Class<?> clazz) {
            return MAP.get(clazz);
        }
    }
}
