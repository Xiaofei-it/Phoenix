package xiaofei.library.phoenix;

import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

public class Phoenix {

    public static void saveInstance(Object instance, Bundle savedInstance) {
        Class<?> clazz = instance.getClass();
        while (!Utils.isBaseClass(clazz)) {
            Utils.saveInstance(clazz, instance, savedInstance);
            clazz = clazz.getSuperclass();
        }
    }

    public static void restoreInstance(Object instance, Bundle savedInstance) {
        Class<?> clazz = instance.getClass();
        while (!Utils.isBaseClass(clazz)) {
            Utils.restoreInstance(clazz, instance, savedInstance);
            clazz = clazz.getSuperclass();
        }
    }
}
