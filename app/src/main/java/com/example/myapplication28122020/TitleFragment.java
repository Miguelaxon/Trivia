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
import android.widget.Toast;

import com.example.myapplication28122020.databinding.FragmentTitleBinding;

public class TitleFragment extends Fragment {
    private FragmentTitleBinding binding;

    public TitleFragment() {
        // Required empty public constructor
    }

    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTitleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.etName.getText().toString().isEmpty()) {
                    addLogoTriviaFragment(binding.etName.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Debes escribir un nombre",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void addLogoTriviaFragment(String name){
        LogoTriviaFragment logoTriviaFragment = LogoTriviaFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, logoTriviaFragment, TitleFragment.
                        class.getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();
    }
}