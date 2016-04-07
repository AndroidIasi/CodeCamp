package ro.androidiasi.codecamp;

import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

@EActivity
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
