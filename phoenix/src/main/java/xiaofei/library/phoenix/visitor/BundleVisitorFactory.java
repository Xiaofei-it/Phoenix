package xiaofei.library.phoenix.visitor;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Xiaofei on 16/11/29.
 */
public class BundleVisitorFactory {

    private static final HashMap<Class<?>, BundleVisitor> MAP = new HashMap<Class<?>, BundleVisitor>() {
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

            // Byte[]???
            put(byte[].class, ByteArrayBundleVisitor.INSTANCE);
            put(char[].class, CharArrayBundleVisitor.INSTANCE);
            put(int[].class, IntArrayBundleVisitor.INSTANCE);
            put(float[].class, FloatArrayBundleVisitor.INSTANCE);
            put(short[].class, ShortArrayBundleVisitor.INSTANCE);
            put(boolean[].class, BooleanArrayBundleVisitor.INSTANCE);
            put(double[].class, DoubleArrayBundleVisitor.INSTANCE);
            put(long[].class, LongArrayBundleVisitor.INSTANCE);
        }
    };

    public static BundleVisitor getBundleVisitor(Class<?> clazz) {
        BundleVisitor bundleVisitor = MAP.get(clazz);
        if (bundleVisitor != null) {
            return bundleVisitor;
        }
        if (Bundle.class.isAssignableFrom(clazz)) {
            return BundleBundleVisitor.INSTANCE;
        }
        if (Parcelable.class.isAssignableFrom(clazz)) {
            return ParcelableBundleVisitor.INSTANCE;
        }
        if (Serializable.class.isAssignableFrom(clazz)) {
            return SerializableBundleVisitor.INSTANCE;
        }
        if (CharSequence.class.isAssignableFrom(clazz)) {
            return CharSequenceBundleVisitor.INSTANCE;
        }
        return MAP.get(clazz);
    }
}
