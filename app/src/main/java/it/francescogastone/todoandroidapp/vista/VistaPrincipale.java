package it.francescogastone.todoandroidapp.vista;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import it.francescogastone.todoandroidapp.Applicazione;
import it.francescogastone.todoandroidapp.R;

public class VistaPrincipale extends Fragment {

    private ListView listView;

    private List<String> items = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.vista_principale, container, false);
        listView = fragment.findViewById(R.id.listView);
        editText = fragment.findViewById(R.id.editText);

        adapter = new ArrayAdapter<String>(Applicazione.getInstance().getApplicationContext(), R.layout.list_view_theme, items);
        listView.setAdapter(adapter);

        //PROVA CANCELLA TUTTO
        //////////////////////////////////////////
        Button button = fragment.findViewById(R.id.buttonAggiungiToDo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().trim().isEmpty()){
                    Log.d("Mex", "Vuoto");

                } else {
                    items.add(editText.getText().toString());
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }

            }
        });

        return fragment;
    }

}
