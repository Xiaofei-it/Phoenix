package xiaofei.library.phoenix.visitor;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Xiaofei on 16/11/25.
 */

class SupportFragmentBundleVisitor implements BundleVisitor {

    private WeakReference<Activity> mRef;

    public SupportFragmentBundleVisitor(Activity activity) {
        mRef = new WeakReference<Activity>(activity);
    }

    @Override
    public void put(Bundle bundle, String key, Object value) {
        if (value != null) {
            bundle.putString(key, ((Fragment) value).getTag());
        }
    }

    @Override
    public Object get(Bundle bundle, String key) {
        Activity activity = mRef.get();
        if (activity instanceof FragmentActivity) {
            return ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(bundle.getString(key));
        }
        return null;
    }
}
