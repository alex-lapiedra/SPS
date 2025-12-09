package com.example.piedrapapeltijera;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;

public class Item {
    ItemType type;

    Item() {
       assignRandomType();
    }

    Item(ItemType type) {
        this.type = type;
    }

    Result winsTo(Item other) {
        if(this.type == other.type) {
            return Result.DRAW;
        }

        if(this.type == ItemType.STONE) {
            if(other.type == ItemType.SCISSORS || other.type == ItemType.LIZARD) {
                return Result.WIN;
            }
            else {
                return Result.LOSE;
            }
        }

        if(this.type == ItemType.PAPER) {
            if(other.type == ItemType.STONE || other.type == ItemType.SPOCK) {
                return Result.WIN;
            }
            else {
                return Result.LOSE;
            }
        }

        if(this.type == ItemType.SCISSORS) {
            if(other.type == ItemType.PAPER || other.type == ItemType.LIZARD) {
                return Result.WIN;
            }
            else {
                return Result.LOSE;
            }
        }

        if(this.type == ItemType.LIZARD) {
            if(other.type == ItemType.SPOCK || other.type == ItemType.PAPER) {
                 return Result.WIN;
            }
            else {
                return Result.LOSE;
            }
        }

        if(this.type == ItemType.SPOCK) {
            if(other.type == ItemType.STONE || other.type == ItemType.SCISSORS) {
                return Result.WIN;
            }
            else {
                return Result.LOSE;
            }
        }
        return null;
    }

    void assignRandomType() {
        double random = Math.random();
        int randomInt = (int)(random * 10);
        randomInt = randomInt % 5;
        if(randomInt == 0) {
            type = ItemType.STONE;
        }
        if(randomInt == 1) {
            type = ItemType.PAPER;
        }
        if(randomInt == 2) {
            type = ItemType.SCISSORS;
        }
        if(randomInt == 3) {
            type = ItemType.LIZARD;
        }
        if(randomInt == 4) {
            type = ItemType.SPOCK;
        }
    }

    @SuppressLint("DiscouragedApi")
    int getResourceId(Context context, Result result) {
        String imageName = toString();

        switch (result) {
            case WIN:
            case DRAW:
                imageName = imageName + "_win";
                break;
            case LOSE:
                imageName = imageName + "_lose";
                break;
        }

        Resources res = context.getResources();
        return res.getIdentifier(imageName , "drawable", context.getPackageName());
    }

    @Override
    public String toString() {
        switch(type) {
            case STONE: return "stone";
            case PAPER: return "paper";
            case SCISSORS: return "scissors";
            case LIZARD: return "lizard";
            case SPOCK: return "spock";
            default: return "";
        }
    }
}


