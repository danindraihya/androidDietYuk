package com.example.dietkuy;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.dietkuy.retrofit.ApiClient;
import com.example.dietkuy.retrofit.JsonPlaceHolderApi;
import com.example.dietkuy.retrofit.model.User;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KenaikanFragment extends Fragment {
    SharedPreferences sharedPreferences;
    Integer id;
    private LineChart mChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
        id = sharedPreferences.getInt("id", -1);

        View rootView = inflater.inflate(R.layout.fragment_kenaikan, container, false);

        mChart = rootView.findViewById(R.id.chart);
        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);

        Description description = new Description();
        description.setText("Kalori Terbakar");
        description.setTextColor(Color.BLUE);
        description.setTextSize(25);
        mChart.setDescription(description);

        mChart.setDrawGridBackground(true);
        mChart.setBackgroundColor(Color.GRAY);
        LineDataSet lineDataSet = new LineDataSet(dataValues(), "Data set 1");

        lineDataSet.setLineWidth(3);
        lineDataSet.setColor(Color.RED);
        lineDataSet.setCircleRadius(5);
        lineDataSet.setValueTextSize(15);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData lineData = new LineData(dataSets);
        mChart.setData(lineData);
        mChart.invalidate();

        return rootView;

    }

    private ArrayList<Entry> dataValues(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 20));
        dataVals.add(new Entry(1, 24));
        dataVals.add(new Entry(2, 2));
        dataVals.add(new Entry(3, 10));
        dataVals.add(new Entry(4, 40));

        return dataVals;
    }
}
