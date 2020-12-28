package com.example.myapplication28122020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication28122020.databinding.FragmentLoserBinding;

public class LoserFragment extends Fragment {
    private FragmentLoserBinding binding;
    private static final String ARG_PARAM1 = "param1";

    private String name;

    public LoserFragment() {
        // Required empty public constructor
    }

    public static LoserFragment newInstance(String param1) {
        LoserFragment fragment = new LoserFragment();
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
        binding = FragmentLoserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String mensaje = getString(R.string.mensajeLoser, name);
        binding.tvMensajeLoser.setText(mensaje);

        binding.btnRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLogoTriviaFragment();
            }
        });
    }
    private void addLogoTriviaFragment(){
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, logoTriviaFragment, TitleFragment.
                        class.getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();
    }

}