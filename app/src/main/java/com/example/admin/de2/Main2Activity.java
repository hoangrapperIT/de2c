package com.example.admin.de2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    ListView listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listData = findViewById(R.id.lv);
        DAO daosP = new DAO(this);
        List<Model> modelSPList = daosP.getSPAll();
        CustomPr customPr = new CustomPr(this, modelSPList);
        listData.setAdapter(customPr);
    }
    class CustomPr extends BaseAdapter
    {
        LayoutInflater inflater;
        List<Model> modelSPS;
        CustomPr(Context context, List<Model> sps)
        {
            inflater = (LayoutInflater)(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
            modelSPS = sps;
        }
        @Override
        public int getCount() {
            return modelSPS.size();
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
            View view =  inflater.inflate(R.layout.custom,null);
            TextView mas = view.findViewById(R.id.masv);
            mas.setText(modelSPS.get(position).getMaSV());
            TextView mal = view.findViewById(R.id.malop);
            mal.setText(modelSPS.get(position).getMaLop());
            TextView dt = view.findViewById(R.id.toan);
            String t = String.valueOf(modelSPS.get(position).getdToan());
            dt.setText(t);
            TextView dv = view.findViewById(R.id.van);
            String v = String.valueOf(modelSPS.get(position).getdVan());
            dv.setText(v);
            return view;
        }
    }
}