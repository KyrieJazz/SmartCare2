package com.example.smartcare2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.smartcare2.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button button_monitor = (Button) root.findViewById(R.id.button_monitor);
        button_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置向Monitor的fragment页面的跳转
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                //fragment的替换规则
                navController.navigate(R.id.action_navigation_home_to_navigation_monitor);
            }
        });
        return root;
    }
}