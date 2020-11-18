package it.francescogastone.todoandroidapp.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import it.francescogastone.todoandroidapp.R;

public class VistaSeconda extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vista_seconda, container, false);

        return view;
    }
}
