package com.example.myapplication28122020;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication28122020.databinding.FragmentWinnerBinding;

public class WinnerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private FragmentWinnerBinding binding;

    private String name;

    public WinnerFragment() {
        // Required empty public constructor
    }

    public static WinnerFragment newInstance(String param1) {
        WinnerFragment fragment = new WinnerFragment();
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
        binding = FragmentWinnerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String mensaje = getString(R.string.mensajeWinner, name);
        binding.textView2.setText(mensaje);
        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTitleFragment();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSalir();
            }
        });
    }

    private void addTitleFragment(){
        TitleFragment titleFragment = TitleFragment.newInstance();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, titleFragment, TitleFragment.
                        class.getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void onSalir(){
        Intent salida = new Intent( Intent.ACTION_MAIN); //Llamando a la activity principal
        System.exit(0); // La cerramos.
    }
}