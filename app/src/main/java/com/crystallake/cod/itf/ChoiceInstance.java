package com.crystallake.cod.itf;

import javax.inject.Qualifier;

/**
 * Created by yds
 * on 2020/4/23.
 */
@Qualifier
public @interface ChoiceInstance {
    int ZERO_PARAMS = 0;
    int ONE_PARAMS = 1;
    int TWO_PARAMS = 2;
    int THREE_PARAMS = 3;
    int FOUR_PARAMS = 4;

    int choiceType() default ZERO_PARAMS;
}
