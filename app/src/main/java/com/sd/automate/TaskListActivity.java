package com.sd.automate;

import android.support.v4.app.Fragment;

/**
 * Created by Saurabh on 23.05.2016.023.
 */
public class TaskListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment(){
        return new TaskListFragment();
    }
}
