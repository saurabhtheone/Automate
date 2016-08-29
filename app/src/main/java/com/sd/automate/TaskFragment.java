package com.sd.automate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.UUID;

/**
 * Created by Saurabh on 22.01.2016.022.
 */
public class TaskFragment extends Fragment {
    private static final String ARG_TASK_ID = "task_id";

    private Task mTask = new Task(false);
    private EditText mTaskName;
    private Button mDateButton;
    private Spinner mSpinner;
    //private CheckBox mCheckBox;

    // newInstance ==>
    public static TaskFragment newInstance(UUID taskId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_ID, taskId);

        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //mTask = new Task(false);
        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        mTask = TaskLab.get(getActivity()).getTask(taskId);
        //Toast.makeText(getContext(),mTask.getTaskName()+"<-",Toast.LENGTH_LONG).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_task, container, false);

        mTaskName = (EditText)v.findViewById(R.id.task_title);

        /* Set textname if it is not null ==>
        * */
        if (mTask.getTaskName()!=null) {
            mTaskName.setText(mTask.getTaskName());
        }

        /* Add text changed listener
        * */
        mTaskName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setTaskName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* Set mCheckBox ==>
        * */
        //mCheckBox = (CheckBox)v.findViewById(R.id.task_complete_check_box);
        //mCheckBox.setChecked(mTask.getComplete());

        /* Set mDateButton ==>
        * */
        mDateButton = (Button)v.findViewById(R.id.task_date);
        mDateButton.setText(mTask.getScheduleDate().toString());
        mDateButton.setEnabled(false);

        /* Set mSpinner ==>
        * */
        mSpinner = (Spinner)v.findViewById(R.id.task_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String items = mSpinner.getSelectedItem().toString();
                //Toast.makeText(getContext(),items, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }
}
