package fmrsabino.moviesdb.ui.base;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        onViewAttached();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onViewDetached();
    }

    protected abstract void onViewAttached();
    protected abstract void onViewDetached();
}
