package it.francescogastone.todoandroidapp.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.francescogastone.todoandroidapp.Applicazione;
import it.francescogastone.todoandroidapp.R;

public class VistaPrincipale extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment = inflater.inflate(R.layout.vista_principale, container, false);
        listView = fragment.findViewById(R.id.listView);
        editText = fragment.findViewById(R.id.editText);

        adapter = new ArrayAdapter<String>(Applicazione.getInstance().getApplicationContext(), R.layout.list_view_theme,
                (List<String>)Applicazione.getInstance().getModello().getBean("LISTA"));
        listView.setAdapter(adapter);

        Button button = fragment.findViewById(R.id.buttonAggiungiToDo);
        button.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneAggiungiToDo());

        listView.setOnItemClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneClickListViewItem());

        return fragment;
    }

    public String getTestoToDo(){
        return this.editText.getText().toString();
    }

    public void aggiornaListView(){
        this.adapter.notifyDataSetChanged();
    }

    public void clearEditText(){
        this.editText.setText("");
    }

}
