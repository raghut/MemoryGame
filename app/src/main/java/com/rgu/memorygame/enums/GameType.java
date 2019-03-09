package com.rgu.memorygame.enums;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.rgu.memorygame.enums.GameType.EASY;
import static com.rgu.memorygame.enums.GameType.HARD;
import static com.rgu.memorygame.enums.GameType.NORMAL;

@Retention(RetentionPolicy.SOURCE)
@IntDef({EASY, NORMAL, HARD})
public @interface GameType {
    int EASY = 1;
    int NORMAL = 2;
    int HARD = 3;

}
