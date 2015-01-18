package com.example.collonville.findingprimenumberapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private EditText start,end;
    private Button startCalcBtn;
    private TextView outputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (EditText)findViewById(R.id.startingNum);
        end = (EditText)findViewById(R.id.endingNum);

        outputTxt = (TextView) findViewById(R.id.outputText);

        startCalcBtn = (Button)findViewById(R.id.startCalcBtn);
        startCalcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int startNum = Integer.parseInt(start.getText().toString());
                int finishNum = Integer.parseInt(end.getText().toString());

                outputTxt.setText(String.valueOf(getPrimeNumCnt(startNum,finishNum)));
            }
        });
    }

    /**
     *
     * @param start
     *  素数判定の開始数値
     * @param end
     *  素数判定の終了数値
     * @return
     */
    private int getPrimeNumCnt(final int start,final int end) {
        int numOfPrimeNum = 0;

        for(int cnt = start; cnt <= end; cnt++){
            if(isPrimeNum(cnt))
                numOfPrimeNum++;
        }

        return numOfPrimeNum;
    }

    /**
     *
     * @param num
     *  素数かどうかを判定させる数値
     * @return
     */
    private boolean isPrimeNum(int num) {
        if( num == 2 )
            return true;
        if( num < 2 || num % 2 == 0 )
            return false;
        for( int n = 3; n <= Math.sqrt((double)num); n += 2 )
            if( num % n == 0 )
                return false;

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
