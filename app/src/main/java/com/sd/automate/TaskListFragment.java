package com.sd.automate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Saurabh on 23.05.2016.023.
 */
public class TaskListFragment extends Fragment {
    private RecyclerView mTaskRecyclerView;
    private TaskAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        mTaskRecyclerView = (RecyclerView) view.findViewById(R.id.task_recycler_view);
        mTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        TaskLab taskLab = TaskLab.get(getActivity());
        List<Task> tasks = taskLab.getTasks();

        if (mAdapter==null) {
            mAdapter = new TaskAdapter(tasks);
            mTaskRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.notifyDataSetChanged(); //very inefficient, instead use notifyItemChanged(int);
            //mAdapter.notifyItemChanged(mAdapter.getPosition());
        }
        //Toast.makeText(getActivity(), tasks.toString(), Toast.LENGTH_LONG).show();
    }

    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //public TextView mTitleTextView;
        private TextView mNameTextView;
        private TextView mDateTextView;
        private CheckBox mCompleteCheckBox;
        private Task mTask;


        public TaskHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

            //mTitleTextView = (TextView) itemView;
            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_task_name_text_view);
            mDateTextView = (TextView) itemView.findViewById(R.id.list_item_date_text_view);
            mCompleteCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_task_complete_check_box);
        }

        public void bindTask(Task task){
            mTask = task;
            mNameTextView.setText(task.getTaskName());
            mDateTextView.setText(task.getScheduleDate().toString());
            mCompleteCheckBox.setChecked(task.getComplete());
        }

        /* Create onClick method when any view is clicked ==>
        * */
        @Override
        public void onClick(View v){
            //Toast.makeText(getActivity(),mTask.getTaskName()+" Clicked!!!", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(getActivity(), TaskPagerActivity.class);

            // Call new activity ==>
            Intent intent = TaskPagerActivity.newIntent(getActivity(), mTask.getId());
            startActivity(intent);
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{
        private List<Task> mTasks;
        //private int position;

        public TaskAdapter(List<Task> tasks){
            mTasks = tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_task, parent, false);
            //View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            //simple_list_item_1 is a layout from the Android standard library
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position){
            Task task = mTasks.get(position);
            //holder.mTitleTextView.setText(task.getTaskName());
            holder.bindTask(task);
            //position = holder.getAdapterPosition();
        }

        @Override
        public int getItemCount(){
            return mTasks.size();
        }

        //private int getPosition(){
            //return this.position;
        //}
    }
}
