package com.example.jh.checkedtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CheckedTextView checkedTextView1;
    private CheckedTextView checkedTextView3;
    private CheckedTextView checkedTextView4;
    private int count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        listView = (ListView) findViewById(R.id.listView);
        checkedTextView1 = (CheckedTextView) findViewById(R.id.checkedTextView1);
        checkedTextView3 = (CheckedTextView) findViewById(R.id.checkedTextView3);
        checkedTextView4 = (CheckedTextView) findViewById(R.id.checkedTextView4);

        //设置checkedTextView1为选中状态
        checkedTextView1.setChecked(true);

        //设置checkedTextView3为选中状态，并更改其显示图标
        checkedTextView3.setChecked(true);
        checkedTextView3.setCheckMarkDrawable(android.R.drawable.arrow_down_float);
        //设置checkedTextView4反转状态，由默认的未选中反转为选中状态
        checkedTextView4.toggle();

        //点击状态后变更相反，如选中变为未选中，未选中的变为选中
        checkedTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedTextView1.toggle();
            }
        });

        //点击状态后变更相反，即下三角转化为上三角符号
        checkedTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if (count % 2 != 0)
                    checkedTextView3.setCheckMarkDrawable(android.R.drawable.arrow_up_float);
                else
                    checkedTextView3.setCheckMarkDrawable(android.R.drawable.arrow_down_float);
            }
        });

        //点击状态后变更相反，如选中变为未选中，未选中的变为选中
        checkedTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkedTextView4.toggle();
            }
        });

        //设置listView的模式为CHOICE_MODE_SINGLE
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}