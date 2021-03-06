/**
 *
 * Copyright 2016 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xiaofei.library.phoenix;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/25.
 */

public class Phoenix {

    public static void saveInstance(Object instance, Bundle savedInstance) {
        Class<?> clazz = instance.getClass();
        while (!Utils.isBaseClass(clazz)) {
            if (!Utils.saveInstance(clazz, instance, savedInstance)) {
                if (!(instance instanceof Activity)) {
                    savedInstance.clear();
                    return;
                }
            }
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
