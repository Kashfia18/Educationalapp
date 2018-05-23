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

    //Declaring member variables

    private RadioGroup mQuestionOne;
    private RadioButton mQuestionOneOptionFour;


    private LinearLayout mQuestionTwo;
    private CheckBox mQuestionTwoOptionOne;
    private CheckBox mQuestionTwoOptionTwo;
    private CheckBox mQuestionTwoOptionThree;
    private CheckBox mQuestionTwoOptionFour;
    private CheckBox mQuestionTwoOptionFive;

    private LinearLayout mQuestionThree;
    private EditText mMyEditTextThree;


    private LinearLayout mQuestionFour;
    private EditText mMyEditTextFour;

    private LinearLayout mQuestionFive;
    private CheckBox mQuestionFiveOptionOne;
    private CheckBox mQuestionFiveOptionTwo;
    private CheckBox mQuestionFiveOptionThree;
    private CheckBox mQuestionFiveOptionFour;
    private CheckBox mQuestionFiveOptionFive;

    private RadioGroup mQuestionSix;
    private RadioButton mQuestionSixOptionThree;

    //Declare and initialize the score of quiz to zero;
    private int mScore=0;

    //Declares and initializes the number of clicks of submit button to zero.
    private int mClick = 0;

    //declares integer variables for saving state (initial/correct/incorrect) of the questions.
    private int mBackgroundQuestionOne;
    private int mBackgroundQuestionTwo;
    private int mBackgroundQuestionThree;
    private int mBackgroundQuestionFour;
    private int mBackgroundQuestionFive;
    private int mBackgroundQuestionSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hides the keyboard for edit TextViews.
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //initialize the views.
        mQuestionOne =findViewById(R.id.question_1);
        mQuestionOneOptionFour =findViewById(R.id.question_1_option_4);

        mQuestionTwo = findViewById(R.id.question_2);
        mQuestionTwoOptionOne = findViewById(R.id.question_2_option_1);
        mQuestionTwoOptionTwo = findViewById(R.id.question_2_option_2);
        mQuestionTwoOptionThree = findViewById(R.id.question_2_option_3);
        mQuestionTwoOptionFour = findViewById(R.id.question_2_option_4);
        mQuestionTwoOptionFive = findViewById(R.id.question_2_option_5);

        mQuestionThree = findViewById(R.id.question_3);
        mMyEditTextThree = findViewById(R.id.insert_answer_question_3);

        mQuestionFour = findViewById(R.id.question_4);
        mMyEditTextFour = findViewById(R.id.insert_answer_question_4);

        mQuestionFive = findViewById(R.id.question_5);
        mQuestionFiveOptionOne = findViewById(R.id.question_5_option_1);
        mQuestionFiveOptionTwo = findViewById(R.id.question_5_option_2);
        mQuestionFiveOptionThree = findViewById(R.id.question_5_option_3);
        mQuestionFiveOptionFour = findViewById(R.id.question_5_option_4);
        mQuestionFiveOptionFive = findViewById(R.id.question_5_option_5);

        mQuestionSix =findViewById(R.id.question_6);
        mQuestionSixOptionThree=findViewById(R.id.question_6_option_3);

        //makes background image transparent.
        // ScrollView mScrollView;
        ScrollView mScrollView;
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
        outState.putInt("click", mClick);
        outState.putInt("background_question_1",mBackgroundQuestionOne);
        outState.putInt("background_question_2",mBackgroundQuestionTwo);
        outState.putInt("background_question_3",mBackgroundQuestionThree);
        outState.putInt("background_question_4",mBackgroundQuestionFour);
        outState.putInt("background_question_5",mBackgroundQuestionFive);
        outState.putInt("background_question_6",mBackgroundQuestionSix);

    }


    /**
     * Restores data to the saved state when activity is recreated.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // restores the values from their saved instances
        mClick = savedInstanceState.getInt("click");

        //restoring background color
        mBackgroundQuestionOne= savedInstanceState.getInt("background_question_1");
        if (mBackgroundQuestionOne == 9) { //if answer correct
            mQuestionOne.setBackgroundResource(R.drawable.box_green_layout);
        } else if(mBackgroundQuestionOne == 8){ // initial blue background.
            mQuestionOne.setBackgroundResource(R.drawable.box_layout);
        }

        mBackgroundQuestionTwo= savedInstanceState.getInt("background_question_2");
        if (mBackgroundQuestionTwo == 9) {
            mQuestionTwo.setBackgroundResource(R.drawable.box_green_layout);
        } else if(mBackgroundQuestionTwo == 8){
            mQuestionTwo.setBackgroundResource(R.drawable.box_layout);
        }

        mBackgroundQuestionThree= savedInstanceState.getInt("background_question_3");
        if (mBackgroundQuestionThree == 9) {
            mQuestionThree.setBackgroundResource(R.drawable.box_green_layout);
        } else if(mBackgroundQuestionThree == 8){
            mQuestionThree.setBackgroundResource(R.drawable.box_layout);
        }

        mBackgroundQuestionFour= savedInstanceState.getInt("background_question_4");
        if (mBackgroundQuestionFour == 9) {
            mQuestionFour.setBackgroundResource(R.drawable.box_green_layout);
        } else if(mBackgroundQuestionFour == 8){
            mQuestionFour.setBackgroundResource(R.drawable.box_layout);
        }

        mBackgroundQuestionFive= savedInstanceState.getInt("background_question_5");
        if (mBackgroundQuestionFive == 9) {
            mQuestionFive.setBackgroundResource(R.drawable.box_green_layout);
        } else if(mBackgroundQuestionFive== 8){
            mQuestionFive.setBackgroundResource(R.drawable.box_layout);
        }

        mBackgroundQuestionSix= savedInstanceState.getInt("background_question_6");
        if (mBackgroundQuestionSix == 9) {
            mQuestionSix.setBackgroundResource(R.drawable.box_green_layout);
        } else if(mBackgroundQuestionSix == 8){
            mQuestionSix.setBackgroundResource(R.drawable.box_layout);
        }

    }

    /**
     * This method is called to calculate the score when the submit button is clicked.
     */
    private int calculate() {
        mScore++;
        return mScore;
    }

    /**
     * This method is called when the submit button is clicked.
     */

    public void submit(View view) {

        //Every time submit button is clicked it adds 1 to click variable
        mClick++;

        //correct answer for question 1.
        boolean  double_helix= mQuestionOneOptionFour.isChecked();

        //When selected for question 1, the if statement will be executed and 1 will be added to the score.
        //On hitting submit button it will show that the answer is correct.
        if (double_helix && mClick == 1) {
            mScore = calculate();
            //turns the background green if the answer is correct
            mQuestionOne.setBackgroundResource(R.drawable.box_green_layout);
            //saves the correct state of the question as green background
            mBackgroundQuestionOne = 9;
        }

        // boolean variables for question 2 where, whether a checkbox has been checked or not is stored.
        boolean adenine = mQuestionTwoOptionOne.isChecked();
        boolean thymine = mQuestionTwoOptionTwo.isChecked();
        boolean guanine = mQuestionTwoOptionThree.isChecked();
        boolean cytosine = mQuestionTwoOptionFour.isChecked();
        boolean uracil = mQuestionTwoOptionFive.isChecked();

        //if this entire condition is true then the answer is correct for question 2 and 1 is added to the score
        //On hitting submit button it will show that the answer is correct.
        if (adenine && thymine && guanine && cytosine && !uracil && mClick == 1) {
            mScore = calculate();
            mQuestionTwo.setBackgroundResource(R.drawable.box_green_layout);
            mBackgroundQuestionTwo = 9;
        }

        //the text in answer field of question 3 is converted to a string and stored in the variable myEditTextValue_3.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_3 = mMyEditTextThree.getText().toString();
        String valueInUpperCase_3 = myEditTextValue_3.toUpperCase();

        // if the text contain "PCR" then the answer would be correct
        //On hitting submit button it will show that the answer is correct.
        if (valueInUpperCase_3.contains(getString(R.string.answer_of_question3)) && mClick == 1) {
            mScore = calculate();
            mQuestionThree.setBackgroundResource(R.drawable.box_green_layout);
            mBackgroundQuestionThree = 9;
        }

        //the text in answer field of question 4 is converted to a string and stored in the variable myEditTextValue_4.
        // All the text is converted to uppercase to compare with the correct answer
        String myEditTextValue_4 = mMyEditTextFour.getText().toString();
        String valueInUpperCase_4 = myEditTextValue_4.toUpperCase();

        // if the text contain "DNA" then the answer would be correct
        //On hitting submit button it will show that the answer is correct.
        if (valueInUpperCase_4.contains(getString(R.string.answer_of_question4)) && mClick == 1) {
            mScore = calculate();
            mQuestionFour.setBackgroundResource(R.drawable.box_green_layout);
            mBackgroundQuestionFour = 9;
        }

        // boolean variables for question 5 where, whether a checkbox has been checked or not is stored.
        boolean phosphate = mQuestionFiveOptionOne.isChecked();
        boolean nitrogenous = mQuestionFiveOptionTwo.isChecked();
        boolean sugar = mQuestionFiveOptionThree.isChecked();
        boolean sulphur = mQuestionFiveOptionFour.isChecked();
        boolean amino = mQuestionFiveOptionFive.isChecked();

        //if this entire condition is true then the answer is correct for question 5 and 1 is added to the score
        if (phosphate && sugar && nitrogenous && !sulphur && !amino && mClick == 1) {
            mScore = calculate();
            mQuestionFive.setBackgroundResource(R.drawable.box_green_layout);
            mBackgroundQuestionFive = 9;
        }

        //correct answer for question 6.
        boolean nucleus = mQuestionSixOptionThree.isChecked();

        //If selected the if statement will be executed and 1 will be added to the score
        //On hitting submit button it will show that the answer is correct.
        if (nucleus && mClick == 1) {
            mScore = calculate();
            mQuestionSix.setBackgroundResource(R.drawable.box_green_layout);
            mBackgroundQuestionSix = 9;
        }

        //Displays the final results in toast message
        if (mClick == 1) {
            //Show the score message as a Toast
            Toast.makeText(MainActivity.this,
                    getString(R.string.your_score_is) + mScore + getString(R.string.out_of_6), Toast.LENGTH_LONG).show();
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
        mClick =0;

        //resets the score to zero.
        mScore = 0;

        //resets the background of the questions to the initial blue state.
        mQuestionOne.setBackgroundResource(R.drawable.box_layout);

        //saves the initial state of the question as blue background in an integer.
        mBackgroundQuestionOne = 8;

        mQuestionTwo.setBackgroundResource(R.drawable.box_layout);
        mBackgroundQuestionTwo = 8;
        mQuestionThree.setBackgroundResource(R.drawable.box_layout);
        mBackgroundQuestionThree = 8;
        mQuestionFour.setBackgroundResource(R.drawable.box_layout);
        mBackgroundQuestionFour = 8;
        mQuestionFive.setBackgroundResource(R.drawable.box_layout);
        mBackgroundQuestionFive = 8;
        mQuestionSix.setBackgroundResource(R.drawable.box_layout);
        mBackgroundQuestionSix = 8;

        //resets the radio buttons, check boxes and editText fields.
        mQuestionOne.clearCheck();

        mQuestionTwoOptionOne.setChecked(false);
        mQuestionTwoOptionTwo.setChecked(false);
        mQuestionTwoOptionThree.setChecked(false);
        mQuestionTwoOptionFour.setChecked(false);
        mQuestionTwoOptionFive.setChecked(false);

        mMyEditTextThree.setText("");

        mMyEditTextFour.setText("");

        mQuestionFiveOptionOne.setChecked(false);
        mQuestionFiveOptionTwo.setChecked(false);
        mQuestionFiveOptionThree.setChecked(false);
        mQuestionFiveOptionFour.setChecked(false);
        mQuestionFiveOptionFive.setChecked(false);

        mQuestionSix.clearCheck();

    }

}