package com.example.dietkuy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dietkuy.adapter.SliderAdapter;
import com.example.dietkuy.models.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class HomeFragment extends Fragment {

    Button btnProgramDiet;
    Button btnProgramLatihan;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);

        btnProgramDiet = rootView.findViewById(R.id.btnProgramDiet);
        btnProgramLatihan = rootView.findViewById(R.id.btnProgramLatihan);

        final SliderView sliderView = rootView.findViewById(R.id.imageSlider);

        SliderAdapter adapter = new SliderAdapter(getActivity());
        adapter.addItem(new SliderItem("Pemula", "https://i.ibb.co/V3Vv40B/pemula.jpg"));
        adapter.addItem(new SliderItem("Menengah", "https://i.ibb.co/jwqKTNc/menengah.jpg"));
        adapter.addItem(new SliderItem("Lanjutan", "https://i.ibb.co/FqtSVRz/lanjutan.jpg"));

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });

        btnProgramDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProgramDietActivity.class);
                startActivity(intent);
            }
        });

        btnProgramLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProgramLatihanActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
