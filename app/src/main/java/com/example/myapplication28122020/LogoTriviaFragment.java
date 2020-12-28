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
import android.widget.RadioGroup;

import com.example.myapplication28122020.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private FragmentLogoTriviaBinding binding;
    private String name;
    private int choice;

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

        binding.rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radiobutton = binding.rdGroup.findViewById(checkedId);
                int index = binding.rdGroup.indexOfChild(radiobutton);
                switch (index){
                    case 0:
                        choice = 0;
                        break;
                    case 1:
                        choice = 1;
                        break;
                    case 2:
                        choice = 2;
                        break;
                    case 3:
                        choice = 3;
                        break;
                    default:
                        choice = 4;
                        break;
                }
            }
        });

        binding.btnEnviarResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( choice == 1){
                    onWinnerFragment(name);
                } else {
                    onLoserFragment(name);
                }
            }
        });
    }

    public void onLoserFragment(String name){
        LoserFragment loserFragment = LoserFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, loserFragment, TitleFragment.
                        class.getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onWinnerFragment(String name){
        WinnerFragment winnerFragment = WinnerFragment.newInstance(name);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .replace(R.id.content_fragment, winnerFragment, TitleFragment.
                        class.getSimpleName()).addToBackStack(null);
        fragmentTransaction.commit();
    }
}