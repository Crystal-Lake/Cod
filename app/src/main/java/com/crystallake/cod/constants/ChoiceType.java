package com.crystallake.cod.constants;

/**
 * Created by yds
 * on 2020/4/23.
 */
public enum ChoiceType {
    ONE_PARAMS (1),
    TWO_PARAMS (2),
    THREE_PARAMS (3),
    FOUR_PARAMS (4);
    final int type;
    ChoiceType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
