package com.ikrarab.teyvatguideimpact;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CharDao {
    @Query("SELECT * FROM charentity")
    List<CharEntity> getAllChar();

    @Insert
    void insert(CharEntity...charEntities);

    @Update
    void update(CharEntity...charEntities);

    @Delete
    void delete(CharEntity...charEntities);
}
