package com.example.mood1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;


import java.util.ArrayList;
import java.util.List;

public class MoodChartFragment extends Fragment {

    private LineChart lineChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mood_chart, container, false);
        lineChart = view.findViewById(R.id.line_chart);

        // 模擬數據，後續可從資料庫加載
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 3)); // 假設數據
        entries.add(new Entry(2, 5));

        LineDataSet dataSet = new LineDataSet(entries, "情緒趨勢");
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();

        return view;
    }
}
