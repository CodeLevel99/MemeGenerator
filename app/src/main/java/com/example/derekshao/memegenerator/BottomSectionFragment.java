package com.example.derekshao.memegenerator;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class BottomSectionFragment extends Fragment {

    private TextView topText;
    private TextView bottomText;
    private RelativeLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);

        topText = (TextView)view.findViewById(R.id.topMemeText);
        bottomText = (TextView)view.findViewById(R.id.bottomMemeText);
        layout = (RelativeLayout)view.findViewById(R.id.bottomLayout);
        Typeface myCustomFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/impact.ttf");
        topText.setTypeface(myCustomFont);
        bottomText.setTypeface(myCustomFont);

        return view;
    }

    public void setMemeText(String top, String bottom) {

        topText.setText(top);
        bottomText.setText(bottom);
    }

    public void setNewPicture(Bitmap image) {
        layout.setBackground(new BitmapDrawable(getResources(), image));
    }

    public void restorePicture(Drawable image) {
        layout.setBackground(image);
    }
}
