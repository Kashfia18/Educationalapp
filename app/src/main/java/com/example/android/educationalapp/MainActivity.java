package com.example.android.educationalapp;


import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * This app is a quiz app. When users answer and hit submit, it shows the score along with which answers are correct
 * and which are incorrect. If a question is left unanswered it is taken as incorrect. If after hitting submit, the
 * user updates a answer and hit submit, it will say "Attempt again" to try the entire quiz again and get a score.
 */

public class MainActivity extends AppCompatActivity{

    //Declaring global variables

    private RadioGroup question_1;
    private RadioButton question_1_option_4;


    private LinearLayout question_2;
    private CheckBox question_2_option_1;
    private CheckBox question_2_option_2;
    private CheckBox question_2_option_3;
    private CheckBox question_2_option_4;
    private CheckBox question_2_option_5;

    private LinearLayout question_3;
    private EditText myEditText_3;


    private LinearLayout question_4;
    private EditText myEditText_4;

    private LinearLayout question_5;
    private CheckBox question_5_option_1;
    private CheckBox question_5_option_2;
    private CheckBox question_5_option_3;
    private CheckBox question_5_option_4;
    private CheckBox question_5_option_5;

    private RadioGroup question_6;
    private RadioButton question_6_option_3;

    //Declare and initialize the score of quiz to zero;
    private int score=0;

    //Declares and initializes the number of clicks of submit button to zero.
    private int click = 0;

    //declares integer variables for saving state (initial/correct/incorrect) of the questions.
    private int background_question_1;
    private int background_question_2;
    private int background_question_3;
    private int background_question_4;
    private int background_question_5;
    private int background_question_6;

    // ScrollView mScrollView;
    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hides the keyboard for edit TextViews.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initialize the views.
        question_1 =findViewById(R.id.question_1);
        question_1_option_4 =findViewById(R.id.question_1_option_4);

        question_2 = findViewById(R.id.question_2);
        question_2_option_1 = findViewById(R.id.question_2_option_1);
        question_2_option_2 = findViewById(R.id.question_2_option_2);
        question_2_option_3 = findViewById(R.id.question_2_option_3);
        question_2_option_4 = findViewById(R.id.question_2_option_4);
        question_2_option_5 = findViewById(R.id.question_2_option_5);

        question_3 = findViewById(R.id.question_3);
        myEditText_3 = findViewById(R.id.insert_answer_question_3);

        question_4 = findViewById(R.id.question_4);
        myEditText_4 = findViewById(R.id.insert_answer_question_4);

        question_5 = findViewById(R.id.question_5);
        question_5_option_1 = findViewById(R.id.question_5_option_1);
        question_5_option_2 = findViewById(R.id.question_5_option_2);
        question_5_option_3 = findViewById(R.id.question_5_option_3);
        question_5_option_4 = findViewById(R.id.question_5_option_4);
        question_5_option_5 = findViewById(R.id.question_5_option_5);

        question_6 =findViewById(R.id.question_6);
        question_6_option_3=findViewById(R.id.question_6_option_3);

        //makes background image transparent.
        mScrollView = findViewById(R.id.background);
        Drawable background = mScrollView.getBackground();
        background.setAlpha(80);

    }

    /**
     * Saves data of activity before it is destroyed
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //save the user's current state
        outState.putInt("click", click);
        outState.putInt("background_question_1",background_question_1);
        outState.putInt("background_question_2",background_question_2);
        outState.putInt("background_question_3",background_question_3);
        outState.putInt("background_question_4",background_question_4);
        outState.putInt("background_question_5",background_question_5);
        outState.putInt("background_question_6",background_question_6);

    }


    /**
     * Restores data to the saved state when activity is recreated.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // restores the values from their saved instances
        click = savedInstanceState.getInt("click");

        //restoring background color
        background_question_1= savedInstanceState.getInt("background_question_1");
        if (background_question_1 == 9) { //if answer correct
            question_1.setBackgroundResource(R.drawable.box_green_layout);
        } else if(background_question_1 == 8){ // initial blue background.
            question_1.setBackgroundResource(R.drawable.box_layout);
        }

        background_question_2= savedInstanceState.getInt("background_question_2");
        if (background_question_2 == 9) {
            question_2.setBackgroundResource(R.drawable.box_green_layout);
        } else if(background_question_2 == 8){
            question_2.setBackgroundResource(R.drawable.box_layout);
        }

        background_question_3= savedInstanceState.getInt("background_question_3");
        if (background_question_3 == 9) {
            question_3.setBackgroundResource(R.drawable.box_green_layout);
        } else if(background_question_3 == 8){
            question_3.setBackgroundResource(R.drawable.box_layout);
        }

        background_question_4= savedInstanceState.getInt("background_question_4");
        if (background_question_4 == 9) {
            question_4.setBackgroundResource(R.drawable.box_green_layout);
        } else if(background_question_4 == 8){
            question_4.setBackgroundResource(R.drawable.box_layout);
        }

        background_question_5= savedInstanceState.getInt("background_question_5");
        if (background_question_5 == 9) {
            question_5.setBackgroundResource(R.drawable.box_green_layout);
        } else if(background_question_5 == 8){
            question_5.setBackgroundResource(R.drawable.box_layout);
        }

        background_question_6= savedInstanceState.getInt("background_question_6");
        if (background_question_6 == 9) {
            question_6.setBackgroundResource(R.drawable.box_green_layout);
        } else if(background_question_6 == 8){
            question_6.setBackgroundResource(R.drawable.box_layout);
        }

    }

    /**
     * This method is called when the submit button is clicked.
     */
    private int calculate() {
        score= score+1;
        return score;
    }

    /**
     * This method is called when the submit button is clicked.
     */

    public void submit(View view) {

        //Every time submit button is clicked it adds 1 to click variable
        click = click + 1;

        //correct answer for question 1.
        boolean  double_helix= question_1_option_4.isChecked();

        //When selected for question 1, the if statement will be executed and 1 will be added to the score.
        //On hitting submit button it will show that the answer is correct.
        if (double_helix && click == 1) {
            score = calculate();
            //turns the background green if the answer is correct
            question_1.setBackgroundResource(R.drawable.box_green_layout);
            //saves the correct state of the question as green background
            background_question_1 = 9;
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
            score = calculate();
            question_2.setBackgroundResource(R.drawable.box_green_layout);
            background_question_2 = 9;
        }

        //the text in answer field of question 3 is converted to a string and stored in the variable myEditTextValue_3.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_3 = myEditText_3.getText().toString();
        String valueInUpperCase_3 = myEditTextValue_3.toUpperCase();

        // if the text contain "PCR" then the answer would be correct
        //On hitting submit button it will show that the answer is correct.
        if (valueInUpperCase_3.contains(getString(R.string.answer_of_question3)) && click == 1) {
            score = calculate();
            question_3.setBackgroundResource(R.drawable.box_green_layout);
            background_question_3 = 9;
        }

        //the text in answer field of question 4 is converted to a string and stored in the variable myEditTextValue_4.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_4 = myEditText_4.getText().toString();
        String valueInUpperCase_4 = myEditTextValue_4.toUpperCase();

        // if the text contain "DNA" then the answer would be correct
        //On hitting submit button it will show that the answer is correct.
        if (valueInUpperCase_4.contains(getString(R.string.answer_of_question4)) && click == 1) {
            score = calculate();
            question_4.setBackgroundResource(R.drawable.box_green_layout);
            background_question_4 = 9;
        }

        // boolean variables for question 5 where, whether a checkbox has been checked or not is stored.
        boolean phosphate = question_5_option_1.isChecked();
        boolean nitrogenous = question_5_option_2.isChecked();
        boolean sugar = question_5_option_3.isChecked();
        boolean sulphur = question_5_option_4.isChecked();
        boolean amino = question_5_option_5.isChecked();

        //if this entire condition is true then the answer is correct for question 5 and 1 is added to the score
        if (phosphate && sugar && nitrogenous && !sulphur && !amino && click == 1) {
            score = calculate();
            question_5.setBackgroundResource(R.drawable.box_green_layout);
            background_question_5 = 9;
        }

        //correct answer for question 6.
        boolean nucleus = question_6_option_3.isChecked();

        //If selected the if statement will be executed and 1 will be added to the score
        //On hitting submit button it will show that the answer is correct.
        if (nucleus && click == 1) {
            score = calculate();
            question_6.setBackgroundResource(R.drawable.box_green_layout);
            background_question_6 = 9;
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

        //resets the score to zero.
        score = 0;

        //resets the background of the questions to the initial blue state.
        question_1.setBackgroundResource(R.drawable.box_layout);

        //saves the initial state of the question as blue background in an integer.
        background_question_1 = 8;

        question_2.setBackgroundResource(R.drawable.box_layout);
        background_question_2 = 8;
        question_3.setBackgroundResource(R.drawable.box_layout);
        background_question_3 = 8;
        question_4.setBackgroundResource(R.drawable.box_layout);
        background_question_4 = 8;
        question_5.setBackgroundResource(R.drawable.box_layout);
        background_question_5 = 8;
        question_6.setBackgroundResource(R.drawable.box_layout);
        background_question_6 = 8;

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