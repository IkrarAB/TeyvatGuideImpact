package com.ikrarab.teyvatguideimpact;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CharEntity {
    @PrimaryKey @NonNull
    public final String name;
    public final String vision;
    public final String weapon;
    public final String nation;
    public final String aff;
    public final int rarity;
    public final String cons;
    public final String birth;
    public final String desc;

    public CharEntity(String name, String vision, String weapon, String nation, String aff, int rarity, String cons, String birth, String desc) {
        this.name = name;
        this.vision = vision;
        this.weapon = weapon;
        this.nation = nation;
        this.aff = aff;
        this.rarity = rarity;
        this.cons = cons;
        this.birth = birth;
        this.desc = desc;
    }
}