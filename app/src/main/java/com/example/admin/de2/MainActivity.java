package com.example.admin.de2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button them,tbt,tbv, tbph, tbpt;
    EditText mssv,malop,toan,van;
    TextView diemt, diemv, diemph, diempt;

    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        them = findViewById(R.id.add);
        toan = findViewById(R.id.diemt);
        van = findViewById(R.id.diemv);
        diemph = findViewById(R.id.diemtbPH);
        diempt = findViewById(R.id.diemtbPT);
        malop = findViewById(R.id.msl);
        mssv = findViewById(R.id.mssv);
        tbt = findViewById(R.id.dtbt);
        tbv = findViewById(R.id.dtbv);
        tbph = findViewById(R.id.dtbph);
        tbpt = findViewById(R.id.dtbpt);
        diemt = findViewById(R.id.diemtbt);
        diemv = findViewById(R.id.diemtbv);
        final DAO daosp = new DAO(this);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO code
                Model modelSP = new Model();
                modelSP.MaSV = mssv.getText().toString();
                modelSP.MaLop = malop.getText().toString();
                modelSP.dToan = Integer.parseInt(toan.getText().toString());
                modelSP.dVan = Integer.parseInt(van.getText().toString());
                daosp.insert(modelSP);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });
        tbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Model> diem = daosp.getSPAll();
                int sumt = 0;
                for(int i = 0; i < diem.size(); i++)
                {
                    sumt += diem.get(i).getdToan();
                }
                Double tbt = Double.valueOf(sumt/diem.size());
                diemt.setText("Toán "+String.valueOf(tbt));
            }
        });
        tbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Model> diem = daosp.getSPAll();
                int sumv = 0;
                for(int i = 0; i < diem.size(); i++)
                {
                    sumv += diem.get(i).getdVan();
                }
                Double tbt = Double.valueOf(sumv/diem.size());
                diemv.setText("Văn "+String.valueOf(tbt));
            }
        });
        tbph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Model> diem = daosp.getLop("PH");
                int sumv = 0;
                int sumt = 0;
                for(int i = 0; i < diem.size(); i++)
                {
                    sumv += diem.get(i).getdVan();
                    sumt += diem.get(i).getdToan();
                }
                Double tbt = Double.valueOf(sumt/diem.size());
                Double tbv = Double.valueOf(sumv/diem.size());
                Double showtb = (tbt + tbv)/2;
                diemph.setText(String.valueOf(showtb));
            }
        });
        tbph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Model> diem = daosp.getLop("PT");
                int sumv = 0;
                int sumt = 0;
                for(int i = 0; i < diem.size(); i++)
                {
                    sumv += diem.get(i).getdVan();
                    sumt += diem.get(i).getdToan();
                }
                Double tbt = Double.valueOf(sumt/diem.size());
                Double tbv = Double.valueOf(sumv/diem.size());
                Double showtb = (tbt + tbv)/2;
                diempt.setText(String.valueOf(showtb));
            }
        });
    }

}