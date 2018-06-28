package com.example.vkeith.quiz;

import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    private TextView correct_answer_q1,
            correct_answer_q2,correct_answer_q3,correct_answer_q4,correct_answer_q5,correct_answer_q6;

    private RadioButton radioQ2Choice1,radioQ2Choice2,radioQ2Choice3,radioQ2Choice4,
            radioQ4Choice1,radioQ4Choice2,radioQ4Choice3;

    private CheckBox chkQ5Option1,chkQ5Option2,chkQ5Option3;

    private LinearLayout info_panel_q1,info_panel_q2,info_panel_q3,info_panel_q4,info_panel_q5,info_panel_q6;

    private ImageView info_image_q1,info_image_q2,info_image_q3,info_image_q4,info_image_q5,info_image_q6;

    private EditText questionOne,questionThree,questionSix;


    private static final String Q1_ANSWER = "krypton";
    private static final int Q3_ANSWER = 206;
    private static final String Q6_ANSWER = "aglet";
    private static final int TOTAL_QUESTIONS =6;

    private Button btnQ1,btnQ2,btnQ3,btnQ4,btnQ5,btnQ6,btnReset;

    int questionsAnswered = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Makes the status bar translucent
        if(Build.VERSION.SDK_INT >= 19){
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        //Prevents the keyboard from popping up automatically
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initControls();
    }

    private void initControls(){

        questionOne = findViewById(R.id.question_one_answer);
        questionThree = findViewById(R.id.question_three_answer);
        questionSix = findViewById(R.id.question_six_answer);

        correct_answer_q1= findViewById(R.id.correct_answer_q1);
        correct_answer_q2= findViewById(R.id.correct_answer_q2);
        correct_answer_q3= findViewById(R.id.correct_answer_q3);
        correct_answer_q4= findViewById(R.id.correct_answer_q4);
        correct_answer_q5= findViewById(R.id.correct_answer_q5);
        correct_answer_q6= findViewById(R.id.correct_answer_q6);

        radioQ2Choice1 = findViewById(R.id.chk_greenland);
        radioQ2Choice2 = findViewById(R.id.chk_madagascar);
        radioQ2Choice3 = findViewById(R.id.chk_australia);
        radioQ2Choice4 = findViewById(R.id.chk_iceland);

        radioQ4Choice1 = findViewById(R.id.chk_nile);
        radioQ4Choice2 = findViewById(R.id.chk_congo);
        radioQ4Choice3 = findViewById(R.id.chk_sa);

        chkQ5Option1 = findViewById(R.id.opt_saturn);
        chkQ5Option2 = findViewById(R.id.opt_neptune);
        chkQ5Option3 = findViewById(R.id.opt_mars);

        btnQ1 = findViewById(R.id.submit_button_q1);
        btnQ1.setOnClickListener(this);
        btnQ2 = findViewById(R.id.submit_button_q2);
        btnQ2.setOnClickListener(this);
        btnQ3 = findViewById(R.id.submit_button_q3);
        btnQ3.setOnClickListener(this);
        btnQ4 = findViewById(R.id.submit_button_q4);
        btnQ4.setOnClickListener(this);
        btnQ5 = findViewById(R.id.submit_button_q5);
        btnQ5.setOnClickListener(this);
        btnQ6 = findViewById(R.id.submit_button_q6);
        btnQ6.setOnClickListener(this);
        btnReset = findViewById(R.id.btn_Reset);
        btnReset.setOnClickListener(this);

        info_panel_q1 = findViewById(R.id.information_layout_q1);
        info_panel_q2 = findViewById(R.id.information_layout_q2);
        info_panel_q3 = findViewById(R.id.information_layout_q3);
        info_panel_q4 = findViewById(R.id.information_layout_q4);
        info_panel_q5 = findViewById(R.id.information_layout_q5);
        info_panel_q6 = findViewById(R.id.information_layout_q6);

        info_image_q1 = findViewById(R.id.info_image_q1);
        info_image_q2 = findViewById(R.id.info_image_q2);
        info_image_q3 = findViewById(R.id.info_image_q3);
        info_image_q4 = findViewById(R.id.info_image_q4);
        info_image_q5 = findViewById(R.id.info_image_q5);
        info_image_q6 = findViewById(R.id.info_image_q6);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.submit_button_q1:
                checkStringAnswer(1);
                break;
            case R.id.submit_button_q2:
                checkBooleanAnswer(2);
                break;
            case R.id.submit_button_q3:
                checkStringAnswer(3);
                break;
            case R.id.submit_button_q4:
                checkBooleanAnswer(4);
                break;
            case R.id.submit_button_q5:
                checkBooleanAnswer(5);
                break;
            case R.id.submit_button_q6:
                checkStringAnswer(6);
                break;
            case R.id.btn_Reset:
                resetControls();
                break;
            default:
                break;
        }
    }

    public void checkIfCompleted(int QuestionsAnswered){

        int answered = QuestionsAnswered;
        if(answered == TOTAL_QUESTIONS ){
            Toast.makeText(this,"Your total score is: "+score+"/"+TOTAL_QUESTIONS,Toast.LENGTH_SHORT).show();
            btnReset.setEnabled(true);
        }

    }

    public void resetControls(){
        //Clear the textboxes
        questionOne.setText("");
        questionThree.setText("");
        questionSix.setText("");

        //Enable the textboxes
        questionOne.setEnabled(true);
        questionThree.setEnabled(true);
        questionSix.setEnabled(true);

        //Clear the radio buttons and checkboxes
        RadioGroup group_1 = findViewById(R.id.q2_radiogroup);
        group_1.clearCheck();

        RadioGroup group_2 = findViewById(R.id.q4_radiogroup);
        group_2.clearCheck();

        chkQ5Option1.setChecked(false);
        chkQ5Option2.setChecked(false);
        chkQ5Option3.setChecked(false);

        resetPanels();
        enableButtons();

        score =0;
        questionsAnswered=0;

        btnReset.setEnabled(false);
    }

    public void resetPanels(){
        info_panel_q1.setVisibility(View.INVISIBLE);
        info_panel_q2.setVisibility(View.INVISIBLE);
        info_panel_q3.setVisibility(View.INVISIBLE);
        info_panel_q4.setVisibility(View.INVISIBLE);
        info_panel_q5.setVisibility(View.INVISIBLE);
        info_panel_q6.setVisibility(View.INVISIBLE);
    }

    public void enableButtons(){
        btnQ1.setEnabled(true);
        btnQ2.setEnabled(true);
        btnQ3.setEnabled(true);
        btnQ4.setEnabled(true);
        btnQ5.setEnabled(true);
        btnQ6.setEnabled(true);
    }

    public void checkBooleanAnswer(int Question){

        if(Question == 2){
            //if any one of the choices is selected
            if(radioQ2Choice1.isChecked()== true ||
                    radioQ2Choice2.isChecked()==true || radioQ2Choice4.isChecked()==true
                    ||radioQ2Choice3.isChecked()==true){
                //Correct choice
                if(radioQ2Choice1.isChecked() == true){
                    info_panel_q2.setVisibility(View.VISIBLE);
                    info_image_q2.setImageDrawable(getDrawable(R.drawable.tick));
                    correct_answer_q2.setText("");
                    score+=1;
                }else{//Wrong choice
                    info_panel_q2.setVisibility(View.VISIBLE);
                    info_image_q2.setImageDrawable(getDrawable(R.drawable.erase));
                    correct_answer_q2.setText(radioQ2Choice1.getText());
                }
                //Check if all questions are answered
                checkIfCompleted(questionsAnswered+=1);
                //Disable the submit button.
                //Activated after the quiz is finished
                btnQ2.setEnabled(false);
            }
        }else if(Question == 4){
            //if any one of the choices is selected
            if(radioQ4Choice1.isChecked()== true ||
                    radioQ4Choice2.isChecked()==true ||radioQ4Choice3.isChecked()==true) {
                //Correct choice
                if (radioQ4Choice1.isChecked() == true) {
                    info_panel_q4.setVisibility(View.VISIBLE);
                    info_image_q4.setImageDrawable(getDrawable(R.drawable.tick));
                    correct_answer_q4.setText("");
                    score+=1;
                } else {//wrong choice
                    info_panel_q4.setVisibility(View.VISIBLE);
                    info_image_q4.setImageDrawable(getDrawable(R.drawable.erase));
                    correct_answer_q4.setText(radioQ4Choice1.getText());
                }
                checkIfCompleted(questionsAnswered+=1);
                //Disable the submit button.
                //Activated after the quiz is finished
                btnQ4.setEnabled(false);
            }
        }else if(Question == 5){
            //if any one of the choices is selected
            if(chkQ5Option1.isChecked()== true ||
                    chkQ5Option2.isChecked()==true ||chkQ5Option3.isChecked()==true) {
                //Correct Answer
                if (chkQ5Option1.isChecked() == true &&
                        chkQ5Option2.isChecked() == true && chkQ5Option3.isChecked() == false) {
                    info_panel_q5.setVisibility(View.VISIBLE);
                    info_image_q5.setImageDrawable(getDrawable(R.drawable.tick));
                    correct_answer_q5.setText("");
                    score+=1;
                } else {
                    info_panel_q5.setVisibility(View.VISIBLE);
                    info_image_q5.setImageDrawable(getDrawable(R.drawable.erase));
                    correct_answer_q5.setText(chkQ5Option1.getText() + "," + chkQ5Option2.getText());
                }

                checkIfCompleted(questionsAnswered+=1);
                //Disable the submit button.
                //Activated after the quiz is finished
                btnQ5.setEnabled(false);
            }
        }

    }

    public void checkStringAnswer(int Question){
         if(Question == 1){
             String answer = questionOne.getText().toString();
             if(!answer.equals("")){
                 //If answer is correct
                 if(answer.equalsIgnoreCase(Q1_ANSWER)){
                     info_panel_q1.setVisibility(View.VISIBLE);
                     info_image_q1.setImageDrawable(getDrawable(R.drawable.tick));
                     correct_answer_q1.setText("");
                     score+=1;
                 }//If answer is wrong
                 else{
                      info_panel_q1.setVisibility(View.VISIBLE);
                      info_image_q1.setImageDrawable(getDrawable(R.drawable.erase));
                      correct_answer_q1.setText(Q1_ANSWER);
                 }
                 checkIfCompleted(questionsAnswered+=1);
                 //Disable the submit button.
                 //Activated after the quiz is finished
                 btnQ1.setEnabled(false);
                 questionOne.setEnabled(false);
             }else{
                 Toast.makeText(this,"Please enter your answer for Q"+Question,Toast.LENGTH_SHORT).show();
             }
         }
         else if(Question == 3){
            try{
                 int answer3 = Integer.parseInt(questionThree.getText().toString());
                 //Makes sure the number entered is a positive integer
                 if(answer3 >= 0 && answer3< Integer.MAX_VALUE){
                     //If answer is correct
                     if(answer3 == Q3_ANSWER){
                         info_panel_q3.setVisibility(View.VISIBLE);
                         info_image_q3.setImageDrawable(getDrawable(R.drawable.tick));
                         correct_answer_q3.setText("");
                         score+=1;
                     }//If answer is wrong
                     else{
                         info_panel_q3.setVisibility(View.VISIBLE);
                         info_image_q3.setImageDrawable(getDrawable(R.drawable.erase));
                         correct_answer_q3.setText(Q3_ANSWER+"");
                     }
                     checkIfCompleted(questionsAnswered+=1);
                     //Disable the submit button.
                     //Activated after the quiz is finished
                     btnQ3.setEnabled(false);
                     questionThree.setEnabled(false);
                 }else{
                     Toast.makeText(this,"Please enter your answer for Q"+Question+".Answer should be a positive number",Toast.LENGTH_SHORT).show();
                 }
             }catch(Exception e){
                 Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
             }

         }
         else if(Question == 6){
             String answer6 = questionSix.getText().toString();
             if(!answer6.equals("")){
                 //If answer is correct
                 if(answer6.equalsIgnoreCase(Q6_ANSWER)){
                     info_panel_q6.setVisibility(View.VISIBLE);
                     info_image_q6.setImageDrawable(getDrawable(R.drawable.tick));
                     correct_answer_q6.setText("");
                     score+=1;
                 }//If answer is wrong
                 else{
                     info_panel_q6.setVisibility(View.VISIBLE);
                     info_image_q6.setImageDrawable(getDrawable(R.drawable.erase));
                     correct_answer_q6.setText(Q6_ANSWER);
                 }
                 checkIfCompleted(questionsAnswered+=1);
                 //Disable the submit button.
                 //Activated after the quiz is finished
                 btnQ6.setEnabled(false);
                 questionSix.setEnabled(false);
             }else{
                 Toast.makeText(this,"Please enter your answer for Q"+Question,Toast.LENGTH_SHORT).show();
             }
         }
    }
}
