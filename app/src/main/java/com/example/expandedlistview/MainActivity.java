package com.example.expandedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //define
    private ExpandableListView expandableListView;
    private MyExpandAdapter myExpandAdapter;

    // 好友群组名称设定
    // 群组名称
    private String[] groupName = new String[]{"在线好友", "大学", "中学"};
    private int[] groupPic = new int[]{R.drawable.g3, R.drawable.g2,
            R.drawable.g1};
    // 好友名称
    private String[][] childName = new String[][]{{"Lily", "Jack"},
            {"Lily", "老刘", "Tom"}, {"小豆", "Jack"}};
    private int[][] childPic = new int[][]{{R.drawable.a7, R.drawable.a6},
            {R.drawable.a3, R.drawable.a4, R.drawable.a5},
            {R.drawable.a1, R.drawable.a2}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView=findViewById(R.id.elv);
        myExpandAdapter=new MyExpandAdapter(this,groupName,childName,groupPic,childPic);
        expandableListView.setAdapter(myExpandAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(),
                        groupName[groupPosition]+":"+childName[groupPosition][childPosition],Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
