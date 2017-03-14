package diogojayme.br.com.vuziq.mvparchitecture.view;

import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import diogojayme.br.com.vuziq.mvparchitecture.R;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;

/**
 * Created by diogojayme on 3/9/17.
 */

@RequiresPresenter(MainService.class)
public class MainActivity extends NucleusActivity<MainService> implements FragmentLogin.LoginSuccessListener {

    @BindView(R.id.fragment_container) FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new FragmentLogin())
                .commit();
    }

    @Override
    public void onLoginSuccess() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FragmentImages())
                .commit();
    }
}
