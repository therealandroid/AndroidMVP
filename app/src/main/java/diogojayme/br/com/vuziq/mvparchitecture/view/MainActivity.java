package diogojayme.br.com.vuziq.mvparchitecture.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import diogojayme.br.com.vuziq.mvparchitecture.R;

/**
 * Created by diogojayme on 3/9/17.
 */

public class MainActivity extends AppCompatActivity implements FragmentLogin.LoginSuccessListener {

    @BindView(R.id.fragment_container) FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new FragmentLogin())
                .commit();
    }

    @Override
    public void onLoginSuccess() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FragmentImages())
                .commit();
    }
}
