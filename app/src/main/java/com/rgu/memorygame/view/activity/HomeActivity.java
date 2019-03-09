package com.rgu.memorygame.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rgu.memorygame.enums.GameType;
import com.rgu.memorygame.R;
import com.rgu.memorygame.databinding.ActivityHomeBinding;
import com.rgu.memorygame.view.fragment.GameFragment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding activityStartBinding;
    GameFragment gameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStartBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_home);

        activityStartBinding.btnEasy.setOnClickListener(view -> {
            startGame(GameType.EASY);
        });
    }

    private void startGame(@GameType int level) {
        gameFragment = GameFragment.newInstance(level);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, gameFragment).commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) != null) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
