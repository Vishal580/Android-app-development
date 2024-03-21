package com.example.crudoperaationp12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crudoperaationp12.MyDBHandler;

public class MainActivity extends AppCompatActivity {
    TextView resultText;
    EditText studentId;
    EditText studentName;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = (TextView) findViewById(R.id.result);
        studentId = (EditText) findViewById(R.id.student_id);
        studentName = (EditText) findViewById(R.id.student_name);
        resultText.setMovementMethod(new ScrollingMovementMethod());
        dbHandler = new MyDBHandler(this);
    }

    public void loadStudents(View view) {
        resultText.setText(dbHandler.loadHandler());
        studentId.setText("");
        studentName.setText("");
    }

    public void addStudent(View view) {
        if (!studentId.getText().toString().isEmpty() &&
                !studentName.getText().toString().isEmpty()) {
            int id = Integer.parseInt(studentId.getText().toString());
            String name = studentName.getText().toString();
            Student student = new Student(id, name);
            long insertId = dbHandler.addHandler(student);
            if (insertId == -1) {
                resultText.setText("Record already exists");
            } else {
                studentId.setText("");
                studentName.setText("");
                resultText.setText("Record added");
            }
        } else {
            resultText.setText("Please fill correct id and name");
        }
    }

    public void updateStudent(View view) {
        if (!studentId.getText().toString().isEmpty() &&
                !studentName.getText().toString().isEmpty()) {
            boolean result = dbHandler.updateHandler(Integer.parseInt(
                            studentId.getText().toString()),
                    studentName.getText().toString());
            if (result) {
                studentId.setText("");
                studentName.setText("");
                resultText.setText("Record Updated");
            } else {
                resultText.setText("No Record Found");
            }
        } else {
            resultText.setText("Please fill correct id and name");
        }
    }

    public void deleteStudent(View view) {
        if (!studentId.getText().toString().isEmpty()) {
            boolean result = dbHandler.deleteHandler(Integer.parseInt(
                    studentId.getText().toString()));
            if (result) {
                studentId.setText("");
                studentName.setText("");
                resultText.setText("Record Deleted");
            } else {
                resultText.setText("No Record Found");
            }
        } else {
            resultText.setText("Please fill correct id");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHandler.close();
    }
}