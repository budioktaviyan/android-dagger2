package com.baculsoft.sample.dagger2.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.baculsoft.sample.dagger2.App;
import com.baculsoft.sample.dagger2.R;
import com.baculsoft.sample.dagger2.injectors.component.DaggerFragmentComponent;
import com.baculsoft.sample.dagger2.injectors.component.FragmentComponent;
import com.baculsoft.sample.dagger2.injectors.module.FragmentModule;
import com.baculsoft.sample.dagger2.utils.Commons;

import javax.inject.Inject;

/**
 * @author Budi Oktaviyan Suryanto (budioktaviyans@gmail.com)
 */
public class MainFragment extends Fragment {

    @Inject
    Commons mCommonUtils;

    @Inject
    public MainFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initInjector();
        initComponent();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private void initInjector() {
        FragmentComponent component = DaggerFragmentComponent.builder()
                                                             .applicationComponent(App.getComponent())
                                                             .fragmentModule(new FragmentModule(this))
                                                             .build();
        component.inject(this);
    }

    private void initComponent() {
        final EditText editText = (EditText) getActivity().findViewById(R.id.et_main_message);
        Button button = (Button) getActivity().findViewById(R.id.btn_main_click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String message = editText.getText().toString();

                if (!TextUtils.isEmpty(message)) {
                    mCommonUtils.makeToast(getContext(), message).show();
                }
            }
        });
    }
}