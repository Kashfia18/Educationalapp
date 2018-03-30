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

public class MainActivity extends AppCompatActivity{

    //Declaring global variables
    RadioGroup question_1;
    RadioButton question_1_option_3;
    RadioButton question_1_option_4;

    CheckBox question_2_option_1;
    CheckBox question_2_option_2;
    CheckBox question_2_option_3;
    CheckBox question_2_option_4;
    CheckBox question_2_option_5;

    EditText myEditText_3;
    TextView question_3;

    EditText myEditText_4;
    TextView question_4;

    CheckBox question_5_option_1;
    CheckBox question_5_option_2;
    CheckBox question_5_option_3;
    CheckBox question_5_option_4;
    CheckBox question_5_option_5;

    RadioGroup question_6;
    RadioButton question_6_option_2;
    RadioButton question_6_option_3;

    //Declares and initializes the number of clicks of submit button to zero.
    int click = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the views

        question_1 =findViewById(R.id.question_1);
        question_1_option_3 =findViewById(R.id.question_1_option_3);
        question_1_option_4 =findViewById(R.id.question_1_option_4);

        question_2_option_1 = findViewById(R.id.question_2_option_1);
        question_2_option_2 = findViewById(R.id.question_2_option_2);
        question_2_option_3 = findViewById(R.id.question_2_option_3);
        question_2_option_4 = findViewById(R.id.question_2_option_4);
        question_2_option_5 = findViewById(R.id.question_2_option_5);

        myEditText_3 = findViewById(R.id.insert_answer_question_3);
        question_3 = findViewById(R.id.correct_question_3);

        myEditText_4 = findViewById(R.id.insert_answer_question_4);
        question_4 = findViewById(R.id.correct_question_4);

        question_5_option_1 = findViewById(R.id.question_5_option_1);
        question_5_option_2 = findViewById(R.id.question_5_option_2);
        question_5_option_3 = findViewById(R.id.question_5_option_3);
        question_5_option_4 = findViewById(R.id.question_5_option_4);
        question_5_option_5 = findViewById(R.id.question_5_option_5);

        question_6 =findViewById(R.id.question_6);
        question_6_option_2 = findViewById(R.id.question_6_option_2);
        question_6_option_3=findViewById(R.id.question_6_option_3);

    }

    /**
     * This method is called when the submit button is clicked.
     */

    public void submit(View view) {

        //Initial score is 0.

        int score = 0;

        //Every time submit button is clicked it adds 1 to click variable
        click=click+1;

        //correct answer for question 1.
        boolean double_helix = question_1_option_4.isChecked();

        //When selected for question 1, the if statement will be executed and 1 will be added to the score.
        //On hitting submit button it will show that the answer is correct.
        if (double_helix && click == 1) {
            score = score + 1;
            question_1_option_3.append(getString(R.string.option_is_correct_add_two_space));
        }

        // boolean variables for question 2 where, whether a checkbox has been checked or not is stored.
        boolean adenine = question_2_option_1.isChecked();

        boolean thymine = question_2_option_2.isChecked();

        boolean guanine = question_2_option_3.isChecked();

        boolean cytosine = question_2_option_4.isChecked();

        boolean uracil = question_2_option_5.isChecked();

        //if this entire condition is true then the answer is correct for question 2 and 1 is added to the score
        //On hitting submit button it will show that the answer is correct.
        if (adenine && thymine && guanine && cytosine && !uracil && click == 1) {
            score = score + 1;
            question_2_option_3.append(getString(R.string.option_is_correct));
        }

        //the text in answer field of question 3 is converted to a string and stored in the variable myEditTextValue_3.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_3 = myEditText_3.getText().toString();
        String valueInUpperCase_3 = myEditTextValue_3.toUpperCase();

        // if the text contain "PCR" then the answer would be correct
        //On hitting submit button it will show that the answer is correct.
        if (valueInUpperCase_3.contains(getString(R.string.answer_of_question3)) && click == 1) {
            score = score + 1;
            question_3.setText(R.string.option_is_correct);
        }

        //the text in answer field of question 4 is converted to a string and stored in the variable myEditTextValue_4.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_4 = myEditText_4.getText().toString();
        String valueInUpperCase_4 = myEditTextValue_4.toUpperCase();

        // if the text contain "DNA" then the answer would be correct
        //On hitting submit button it will show that the answer is correct.
        if (valueInUpperCase_4.contains(getString(R.string.answer_of_question4)) && click == 1) {
            score = score + 1;
            question_4.setText(R.string.option_is_correct);
        }

        // boolean variables for question 5 where, whether a checkbox has been checked or not is stored.
        boolean phosphate = question_5_option_1.isChecked();

        boolean sugar = question_5_option_2.isChecked();

        boolean nitrogenous = question_5_option_3.isChecked();

        boolean sulphur = question_5_option_4.isChecked();

        boolean amino = question_5_option_5.isChecked();

        //if this entire condition is true then the answer is correct for question 5 and 1 is added to the score

        if (phosphate && sugar && nitrogenous && !sulphur && !amino && click == 1) {
            score = score + 1;
            question_5_option_3.append(getString(R.string.option_is_correct));
        }

        //correct answer for question 6.
        boolean nucleus = question_6_option_2.isChecked();

        //If selected the if statement will be executed and 1 will be added to the score
        //On hitting submit button it will show that the answer is correct.

        if (nucleus && click == 1) {
            score = score + 1;
            question_6_option_3.append(getString(R.string.option_is_correct));
        }

        //Displays the final results in toast message

        if (click == 1) {
            //Show the score message as a Toast
            Toast.makeText(MainActivity.this,
                    getString(R.string.your_score_is) + score + getString(R.string.out_of_6), Toast.LENGTH_LONG).show();
            }
        else{
            //Show the alternate message as a Toast
            Toast.makeText(MainActivity.this,
                    R.string.click_attempt_again_to_start_the_quiz_again,
                    Toast.LENGTH_LONG).show();
        }
    }


        /**
     * This method is called when the attempt_again button is clicked. It resets everything.
     */
    public void attempt_again(View view){

        //resets the number of clicks of submit button to zero.
        click =0;

        //Replaces the string "Correct! with the initial values"
        question_1_option_3.setText(R.string.helix);
        question_2_option_3.setText(R.string.guanine);
        question_3.setText("");
        question_4.setText("");
        question_5_option_3.setText(R.string.base);
        question_6_option_3.setText(R.string.mitochondria);

        //resets the radio buttons, check boxes and editText fields.
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