package com.rgu.memorygame.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rgu.memorygame.GameType;
import com.rgu.memorygame.R;
import com.rgu.memorygame.Utils;
import com.rgu.memorygame.databinding.FragmentGameBinding;
import com.rgu.memorygame.view.adapter.ImagesAdapter;


public class GameFragment extends Fragment {
    private static final String GAME_TYPE = "param1";

    private int gameType;

    FragmentGameBinding binding;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param gameType Parameter 1.
     * @return A new instance of fragment GameFragment.
     */
    public static GameFragment newInstance(@GameType int gameType) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putInt(GAME_TYPE, gameType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gameType = getArguments().getInt(GAME_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), getCloumns());
        binding.gameRecyclerView.setLayoutManager(gridLayoutManager);
        binding.gameRecyclerView.setAdapter(new ImagesAdapter(getContext(), Utils.getRandomList(3, 8)));
        Utils.getRandomList(3, 8);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private int getCloumns() {
        if (gameType == GameType.EASY) {
            startTimer(25000);
            return 2;
        }

        return 2; //Need to implement Normal and Hard
    }

    private void startTimer(int time) {
        new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                binding.timerTv.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {

            }
        }.start();
    }
}
