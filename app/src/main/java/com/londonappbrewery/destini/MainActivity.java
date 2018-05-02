package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    private TextView storyTextView;

    private Button topButton;

    private Button bottomButton;

    private int mStoryStatus = 1;

    public void makeButtonsInvisible()
    {
        topButton.setVisibility(View.GONE);
        bottomButton.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        storyTextView = findViewById(R.id.storyTextView);
        topButton = findViewById(R.id.buttonTop);
        bottomButton = findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStoryStatus += 1;
                if (topButton.getText() == getString(R.string.T1_Ans1) || topButton.getText() == getString(R.string.T2_Ans1))
                {
                    storyTextView.setText(getString(R.string.T3_Story));
                    topButton.setText(getString(R.string.T3_Ans1));
                    bottomButton.setText(getString(R.string.T3_Ans2));

                }
                else if (topButton.getText() == getString(R.string.T3_Ans1))
                {
                    storyTextView.setText(getString(R.string.T6_End));
                    makeButtonsInvisible();
                }

                else
                {
                    storyTextView.setText(getString(R.string.T6_End));
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStoryStatus += 1;
                if(bottomButton.getText() == getString(R.string.T1_Ans2))
                {

                    storyTextView.setText(getString(R.string.T2_Story));
                    topButton.setText(getString(R.string.T2_Ans1));
                    bottomButton.setText(getString(R.string.T2_Ans2));
                }
                else if (bottomButton.getText() == getString(R.string.T3_Ans2))
                {
                    storyTextView.setText(getString(R.string.T5_End));
                    makeButtonsInvisible();
                }
                else if (bottomButton.getText() == getString(R.string.T2_Ans2))
                {
                    storyTextView.setText(getString(R.string.T4_End));
                    makeButtonsInvisible();
                }
                else
                {
                    storyTextView.setText(getString(R.string.T5_End));

                }

            }
        });
    }
}
