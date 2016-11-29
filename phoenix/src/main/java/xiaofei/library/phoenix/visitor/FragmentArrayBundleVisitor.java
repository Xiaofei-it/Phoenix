package xiaofei.library.phoenix.visitor;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by Xiaofei on 16/11/29.
 */

class FragmentArrayBundleVisitor extends ArrayBundleVisitor<Fragment> {

    private FragmentBundleVisitor mBundleVisitor;

    FragmentArrayBundleVisitor(Activity activity) {
        mBundleVisitor = new FragmentBundleVisitor(activity);
    }

    @Override
    Fragment getFromBundle(Bundle bundle, String key) {
        return (Fragment) mBundleVisitor.get(bundle, key);
    }

    @Override
    void putIntoBundle(Bundle bundle, String key, Object object) {
        mBundleVisitor.put(bundle, key, object);
    }
}
