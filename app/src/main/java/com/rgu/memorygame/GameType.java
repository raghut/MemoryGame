package com.rgu.memorygame;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.rgu.memorygame.GameType.EASY;
import static com.rgu.memorygame.GameType.HARD;
import static com.rgu.memorygame.GameType.NORMAL;

@Retention(RetentionPolicy.SOURCE)
@IntDef({EASY, NORMAL, HARD})
public @interface GameType {
    int EASY = 1;
    int NORMAL = 2;
    int HARD = 3;

}
