package xiaofei.library.phoenix.visitor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Xiaofei on 16/11/29.
 */

class SupportFragmentArrayBundleVisitor extends ArrayBundleVisitor<Fragment> {

    private FragmentBundleVisitor mBundleVisitor;

    SupportFragmentArrayBundleVisitor(Activity activity) {
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
