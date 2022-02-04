package com.Characters;

enum movementDirection {
    North(1),
    South(-1),
    East(1),
    West(-1);

    public final int value;

    private movementDirection(int value){
        this.value = value;
    }
}
