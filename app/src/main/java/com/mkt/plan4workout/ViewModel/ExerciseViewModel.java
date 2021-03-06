package com.mkt.plan4workout.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mkt.plan4workout.Model.Exercise.Exercise;
import com.mkt.plan4workout.Model.Exercise.ExerciseRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ExerciseViewModel extends AndroidViewModel {
    private ExerciseRepository repository;
    private LiveData<List<Exercise>> allExercises;
    private LiveData<List<Exercise>> allExercisesA;

    public ExerciseViewModel(@NonNull Application application) {
        super(application);
        repository = new ExerciseRepository(application);
        allExercisesA = repository.getAllExercisesA();
        allExercises = repository.getAllExercises();
    }

    public void insert(Exercise exercise) {
        repository.insert(exercise);
    }

    public void update(Exercise exercise) {
        repository.update(exercise);
    }

    public void delete(Exercise exercise) {
        repository.delete(exercise);
    }

    public void deleteAllExercises() {
        repository.deleteAllExercises();
    }

    public void archive(int id) {
        repository.archive(id);
    }

    public List<Exercise> getPlanExercises(int id) throws ExecutionException, InterruptedException {
        return repository.getPlanExercises(id);
    }

    public LiveData<List<Exercise>> getAllExercises() {
        return allExercises;
    }

    public LiveData<List<Exercise>> getAllExercisesA() {
        return allExercisesA;
    }
}
