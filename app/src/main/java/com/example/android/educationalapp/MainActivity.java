package com.example.android.educationalapp;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app calculates and shows the results of a quiz.
 */

public class MainActivity extends AppCompatActivity implements ActionListener{


    //Declaring variables

    RadioGroup question_1;

    CheckBox question_2_option_1;
    CheckBox question_2_option_2;
    CheckBox question_2_option_3;
    CheckBox question_2_option_4;
    CheckBox question_2_option_5;

    EditText myEditText_3;

    EditText myEditText_4;

    CheckBox question_5_option_1;
    CheckBox question_5_option_2;
    CheckBox question_5_option_3;
    CheckBox question_5_option_4;
    CheckBox question_5_option_5;

    RadioGroup question_6;

    Button submit;

    int click = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finds the view with the given id and stores it in the declared variables.

        question_1 =findViewById(R.id.question_1);

        question_2_option_1 = findViewById(R.id.question_2_option_1);
        question_2_option_2 = findViewById(R.id.question_2_option_2);
        question_2_option_3 = findViewById(R.id.question_2_option_3);
        question_2_option_4 = findViewById(R.id.question_2_option_4);
        question_2_option_5 = findViewById(R.id.question_2_option_5);

        myEditText_3 = findViewById(R.id.insert_answer_question_3);

        myEditText_4 = findViewById(R.id.insert_answer_question_4);

        question_5_option_1 = findViewById(R.id.question_5_option_1);
        question_5_option_2 = findViewById(R.id.question_5_option_2);
        question_5_option_3 = findViewById(R.id.question_5_option_3);
        question_5_option_4 = findViewById(R.id.question_5_option_4);
        question_5_option_5 = findViewById(R.id.question_5_option_5);

        question_6 =findViewById(R.id.question_6);



    }

    /**
     * This method is called when the submit button is clicked.
     */

    public void submit(View view) {

        //Initial score is 0.

        int score = 0;

        //correct answer for question 1.

        RadioButton question_1_option_4 = (RadioButton) findViewById(R.id.question_1_option_4);
        boolean double_helix = question_1_option_4.isChecked();

        //If selected the if statement will be executed and 1 will be added to the score
        if (double_helix) {
            score = score + 1;
        }

        // boolean variables for question 2 where, whether a checkbox has been checked or not is stored.
        boolean adenine = question_2_option_1.isChecked();

        boolean thymine = question_2_option_2.isChecked();

        boolean guanine = question_2_option_3.isChecked();

        boolean cytosine = question_2_option_4.isChecked();

        boolean uracil = question_2_option_5.isChecked();

        //if this entire condition is true then the answer is correct for question 2 and 1 is added to the score
        if (adenine && thymine && guanine && cytosine && !uracil) {
            score = score + 1;
        }

        //the text in answer field of question 3 is converted to a string and stored in the variable myEditTextValue_3.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_3 = myEditText_3.getText().toString();
        String valueInUpperCase_3 = myEditTextValue_3.toUpperCase();

        // if the text contain "PCR" then the answer would be correct
        if (valueInUpperCase_3.contains("PCR")) {
            score = score + 1;
        }

        //the text in answer field of question 4 is converted to a string and stored in the variable myEditTextValue_4.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_4 = myEditText_4.getText().toString();
        String valueInUpperCase_4 = myEditTextValue_4.toUpperCase();

        // if the text contain "DNA" then the answer would be correct
        if (valueInUpperCase_4.contains("DNA")) {
            score = score + 1;
        }

        // boolean variables for question 5 where, whether a checkbox has been checked or not is stored.
        boolean phosphate = question_5_option_1.isChecked();

        boolean sugar = question_5_option_2.isChecked();

        boolean nitrogenous = question_5_option_3.isChecked();

        boolean sulphur = question_5_option_4.isChecked();

        boolean amino = question_5_option_5.isChecked();

        //if this entire condition is true then the answer is correct for question 5 and 1 is added to the score

        if (phosphate && sugar && nitrogenous && !sulphur && !amino) {
            score = score + 1;
        }

        //correct answer for question 6.

        RadioButton question_6_option_2 = (RadioButton) findViewById(R.id.question_6_option_2);
        boolean nucleus = question_6_option_2.isChecked();

        //If selected the if statement will be executed and 1 will be added to the score

        if (nucleus) {
            score = score + 1;
        }

        if (score >= 0) {
            //Show the score message as a Toast
            Toast.makeText(MainActivity.this,
                    "Your score is " + score + " out of 6", Toast.LENGTH_LONG).show();
            }
    }

    /**
     * This method is called when the attempt_again button is clicked. It resets everything.
     */
    public void attempt_again(View view){

        question_1.clearCheck();

        question_2_option_1.setChecked(false);
        question_2_option_2.setChecked(false);
        question_2_option_3.setChecked(false);
        question_2_option_4.setChecked(false);
        question_2_option_5.setChecked(false);

        myEditText_3.setText("");

        myEditText_4.setText("");

        question_5_option_1.setChecked(false);
        question_5_option_2.setChecked(false);
        question_5_option_3.setChecked(false);
        question_5_option_4.setChecked(false);
        question_5_option_5.setChecked(false);

        question_6.clearCheck();

    }
}