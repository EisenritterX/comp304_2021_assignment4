package com.example.assignment4.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.assignment4.Model.AppDatabase;
import com.example.assignment4.Model.COM304Assign4Repository;
import com.example.assignment4.Model.Entities.Professor;
import com.example.assignment4.R;
import com.example.assignment4.ViewModel.AppViewModel;

public class LoginActivity extends AppCompatActivity {

    private AppViewModel appViewModel;
    EditText profID, profPassword;
    Button login;
    Professor newProf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set View Model
        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        // Create Default Professors
        createTestProfs();

        // Set Gif Logo image
        Glide.with(this).load(R.drawable.assignment_4_logo_gif).
                into((ImageView) findViewById(R.id.imageView));

        // Find username and password
        profID = findViewById(R.id.edittxtLoginID);
        profPassword = findViewById(R.id.edittxtPassword);

        // Login Button and its functionality
        login = findViewById(R.id.buttonLogin);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Getting Professor password
                int profIDInt;
                String profIDStr =  profID.getText().toString();
                String profPassStr = profPassword.getText().toString();



//                System.out.println(appViewModel.ProfLogin(profIDInt,profPassStr));
                // Validation
                if(profIDStr.isEmpty()||profPassStr.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter Valid ID and Password",
                            Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        profIDInt = Integer.parseInt(profIDStr);
                        if (appViewModel.ProfLogin(profIDInt,profPassStr)==null){ //<----- This is the Major Error, it cannot call the function as the function itself crashes the app, unfortunately does not know why
                            Toast.makeText(getApplicationContext(), "This professor is not " +
                                            "in database. Make sure you have entered the correct ID" +
                                            " and Password!" ,
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            try{
                                Professor curProf =appViewModel.ProfLogin(profIDInt,profPassStr);
                                Toast.makeText(getApplicationContext(), "This professor is" +
                                                curProf.getFirstname(),
                                                Toast.LENGTH_SHORT).show();

                                //curProf.getFirstname() +" "+ curProf.getLastname()
                            } catch (NullPointerException npe){
                                Toast.makeText(getApplicationContext(), "Exception Error Found" +profIDInt,
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (NumberFormatException | InterruptedException nfe){
                        Toast.makeText(getApplicationContext(), "Could not parse String Text",
                            Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void createTestProfs(){
        newProf = new Professor(0004, "Rean","Schwartz",
                "Practical Combat","CS4");
        appViewModel.insert(newProf);

    }
}
