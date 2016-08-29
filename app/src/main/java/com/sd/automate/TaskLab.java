package com.sd.automate;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Saurabh on 23.05.2016.023.
 */
public class TaskLab {
    private static TaskLab sTaskLab;

    private List<Task> mTasks;

    public static TaskLab get(Context context){
        if (sTaskLab==null){
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }

    private TaskLab(Context context){
        mTasks = new ArrayList<>();
        for (int i=1; i<100; i++){
            Task task = new Task(false);
            task.setTaskName("Task #"+i);
            mTasks.add(task);
        }
    }

    public List<Task> getTasks(){
        return mTasks;
    }

    public Task getTask(UUID taskId){
        for (Task task : mTasks){
            if (task.getId().equals(taskId)){
                return task;
            }
        }
        return null;
    }
}
