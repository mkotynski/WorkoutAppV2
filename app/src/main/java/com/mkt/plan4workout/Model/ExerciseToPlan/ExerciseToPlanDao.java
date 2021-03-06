package com.mkt.plan4workout.Model.ExerciseToPlan;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExerciseToPlanDao {

    @Insert
    void insert(ExerciseToPlan e2p);

    @Update
    void update(ExerciseToPlan e2p);

    @Delete
    void delete(ExerciseToPlan e2p);

    @Query("SELECT * FROM exercise_2_plan")
    LiveData<List<ExerciseToPlan>> getAlle2p();

    @Query("DELETE FROM exercise_2_plan")
    void deleteAlle2p();

    @Query("SELECT * FROM exercise_2_plan WHERE planId = :planId")
    List<ExerciseToPlan> getExercisesOfPlan(int planId);

    @Query("DELETE FROM exercise_2_plan WHERE planId = :planId")
    void deleteExercisesOfPlan(int planId);

    @Query("DELETE FROM exercise_2_plan WHERE exerciseId = :exerciseId")
    void deleteExercisesById(int exerciseId);
}
