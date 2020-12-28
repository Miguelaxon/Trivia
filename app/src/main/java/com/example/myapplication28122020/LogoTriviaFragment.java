package com.example.myapplication28122020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication28122020.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private FragmentLogoTriviaBinding binding;
    private String name;

    public LogoTriviaFragment() {
        // Required empty public constructor
    }

    public static LogoTriviaFragment newInstance(String param1) {
        LogoTriviaFragment fragment = new LogoTriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String saludo = getString(R.string.saludo, name);
        binding.tvName.setText(saludo);
    }
}