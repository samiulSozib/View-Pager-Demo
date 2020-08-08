package com.samiul.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] color=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models=new ArrayList<>();
        models.add(new Model(R.drawable.a,"A","hi i am samiul bashar. iread in jashore university of science and technology"));
        models.add(new Model(R.drawable.b,"B","it is b"));
        models.add(new Model(R.drawable.c,"C","it is c"));
        models.add(new Model(R.drawable.d,"D","it is d"));

        adapter=new Adapter(models,this);
        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] color_temp={getResources().getColor(R.color.color1),getResources().getColor(R.color.color2),
        getResources().getColor(R.color.color3),getResources().getColor(R.color.color4)};

        color=color_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount()-1) && position<(color.length-1) )  {
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset,color[position],color[position+1]));
                }else{
                    viewPager.setBackgroundColor(color[color.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(getApplicationContext(),"dsfhdsufh"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
