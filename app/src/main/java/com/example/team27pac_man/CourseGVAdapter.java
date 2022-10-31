package com.example.team27pac_man;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class CourseGVAdapter extends ArrayAdapter<Integer> {

    public CourseGVAdapter(@NonNull Context context, ArrayList<CourseModel> layoutIds) {
        super(context, 0, layoutIds);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        CourseModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.testText);
        ImageView courseIV = listitemView.findViewById(R.id.testImage);

        courseTV.setText(courseModel.getLayout_id());
        courseIV.setImageResource(courseModel.getImgid());
        return listitemView;
    }
}
