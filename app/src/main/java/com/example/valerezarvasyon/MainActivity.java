package com.example.valerezarvasyon;


import android.os.Bundle;

import com.example.valerezarvasyon.helper.fragment.FragmentController;
import com.example.valerezarvasyon.helper.fragment.FragmentListener;
import com.example.valerezarvasyon.model.FragmentModel;

import java.util.Stack;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    /**
     * Fragment yapısı için gerekli tanımlamalar
     */
    private FragmentController fragmentController = new FragmentController();


    private Stack<FragmentModel> fragmentStack = new Stack<>();
    private Stack<Bundle> bundleStack = new Stack<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //fragment controller init.
        fragmentController = fragmentController.getInstance(this.getApplicationContext());
        onFragmentChange(FragmentController.LOGIN);
    }


    @Override
    public void onFragmentChange(FragmentModel fragment) {
        this.onFragmentChange(fragment,null);
    }

    @Override
    public void onFragmentChange(FragmentModel fragment, Bundle bundle) {
        if (!fragment.getFragmentId().equals(FragmentController.getCurrentFragment())) {
            fragmentStack.add(fragment);
            bundleStack.add(bundle);

            if (fragment.getFragmentId().equals(FragmentController.REZERVASYON.getFragmentId()));


                FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentController controller = fragmentController.getInstance(this);
            Fragment tFragment = controller.getFragment(fragment.getFragmentId(), bundle);
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            fragmentTransaction.replace(R.id.fl_main_container, tFragment);
            fragmentTransaction.disallowAddToBackStack();
            fragmentTransaction.commit();

        }


    }
}