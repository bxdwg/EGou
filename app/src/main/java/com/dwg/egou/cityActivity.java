package com.dwg.egou;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class cityActivity extends Activity implements View.OnClickListener,onTouchSiderBar{
    private TextView cityForBack;
    private ListView listView ;
    private MyAdapter adapter;
    private List<String> cityLetter = new ArrayList<String>();
    private List<String> cityName = new ArrayList<String>();
    private int[] positions={0,19,24,30,39,46,47,50,56,69,82,87,95,
            100,107,114,124,130,141,148,159};
    private siderBar citySidreBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MyAdapter();
        setContentView(R.layout.activity_city);
        listView = (ListView) findViewById(R.id.cityLists);
        cityLetter = Arrays.asList(getResources().getStringArray(R.array.city_name_order_letter));
        cityName = Arrays.asList(getResources().getStringArray(R.array.city_name));
        Log.e("sie:>>"+cityName.size(),"");
        listView.setAdapter(adapter);
        cityForBack = (TextView) findViewById(R.id.cityForBack);
        cityForBack.setClickable(true);
        cityForBack.setFocusable(true);
        cityForBack.setOnClickListener(this);
        citySidreBar = (siderBar) findViewById(R.id.siderBar);
        citySidreBar.setOnTouchSiderBar(this);

        MyApp.FinishListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cityForBack:
                finish();
                break;
        }
    }

    @Override
    public void setOnTouchLetterListener(String s) {
        Log.e("问题解决了","问题解决了");
        int position = findPosition(s);
        if(position != -1){
            listView.setSelection(position);
        }
    }
    private int findPosition(String s) {
        for (int i=0;i<cityLetter.size();i++){
            if(cityLetter.get(i).equals(s))
            {
                return i;
            }
        }
        Toast.makeText(this,"暂无信息",Toast.LENGTH_SHORT).show();
        return -1;
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return cityName.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if(convertView == null) {
                holder = new Holder();
                convertView = LayoutInflater.from(cityActivity.this).inflate(R.layout.city_item, null,true);
                holder.cityletter = (TextView) convertView.findViewById(R.id.cityLetter);
                holder.cityName = (TextView) convertView.findViewById(R.id.cityName);

                convertView.setTag(holder);
            }
          else{
                holder = (Holder) convertView.getTag();
            }
            holder.cityName.setText(cityName.get(position));
            if(isContain(positions,position))
            {
                holder.cityletter.setText(cityLetter.get(position));
                holder.cityletter.setVisibility(View.VISIBLE);
            }
            else {
                holder.cityletter.setVisibility(View.GONE);
            }
            return convertView;
        }


    }

    private class Holder {
        TextView cityletter = (TextView) findViewById(R.id.cityLetter);
        TextView cityName = (TextView) findViewById(R.id.cityName);
    }
    boolean isContain(int[] array,int position)
    {
        for (int i=0;i<array.length;i++)
        {
            if (array[i] == position)
                return true;

        }
        return false;
    }
}
