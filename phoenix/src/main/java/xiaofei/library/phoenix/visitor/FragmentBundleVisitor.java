package xiaofei.library.phoenix.visitor;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * Created by Xiaofei on 16/11/25.
 */

class FragmentBundleVisitor implements BundleVisitor {

    private WeakReference<Activity> mRef;

    FragmentBundleVisitor(Activity activity) {
        mRef = new WeakReference<Activity>(activity);
    }

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                bundle.putString(key, ((Fragment) value).getTag());
            }
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        if (Build.VERSION.SDK_INT >= 11) {
            Activity activity = mRef.get();
            return activity.getFragmentManager().findFragmentByTag(bundle.getString(key));
        }
        return null;
    }
}
