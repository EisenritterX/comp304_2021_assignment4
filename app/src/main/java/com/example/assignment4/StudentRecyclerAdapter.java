package com.example.assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment4.Model.Entities.Student;

import java.util.List;

public class StudentRecyclerAdapter extends  RecyclerView.Adapter<StudentRecyclerAdapter.ViewHolder>{

//    public StudentAdapter(Context context, List<Student> students) {
//        super(context, 0, students);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get the data item for this position
//        Student student = getItem(position);
//        // Check if an existing view is being reused, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_list_item, parent, false);
//        }
//        // Lookup view for data population
//        //TextView tvName = (TextView) convertView.findViewById(R.id.userLvItemTV);
//        // Populate the data into the template view using the data object
//        //tvName.setText(student.getStudentId());
//        // Return the completed view to render on screen
//        return convertView;
//    }
    private List<Student> students;
    private Context mContext;

    public StudentRecyclerAdapter(List<Student> students, Context mContext) {
        this.students = students;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView stuID, stuFName,stuLName, stuDept, stuProfID, stuClassID;
        TableLayout studentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            /*stuID = itemView.findViewById(R.id.ItemStudentID);
            stuFName = itemView.findViewById(R.id.ItemStudentFname);
            stuLName = itemView.findViewById(R.id.ItemStudentLname);
            stuDept = itemView.findViewById(R.id.ItemStudentDept);
            stuProfID = itemView.findViewById(R.id.ItemStudentProfID);
            stuClassID = itemView.findViewById(R.id.ItemStudentClassID);
            studentLayout = itemView.findViewById(R.id.ItemStudentTable);*/
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRecyclerAdapter.ViewHolder holder, int position) {
        holder.stuID.setText(students.get(position).getStudentId());
        holder.stuFName.setText(students.get(position).getFirstname());
        holder.stuLName.setText(students.get(position).getLastname());
        holder.stuDept.setText(students.get(position).getDepartment());
        holder.stuProfID.setText(students.get(position).getProfessorId());
        holder.stuClassID.setText(students.get(position).getClassroomId());

        holder.studentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,students.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

}
