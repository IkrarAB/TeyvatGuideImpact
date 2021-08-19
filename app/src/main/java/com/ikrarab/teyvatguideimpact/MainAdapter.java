package com.ikrarab.teyvatguideimpact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] charName;
    private String[] charVision;
    private String[] charWeapon;
    private int[] charIcon;
    private int[] charPortrait;
    private int[] charVisionIcon;
    private int[] charRarity;
    private int[] charNation;

    public MainAdapter(Context c, String[] charName, String[] charVision, String[]charWeapon, int[] charIcon, int[] charPortrait,
                       int[] charVisionIcon, int[] charRarity, int[] charNation) {
        context = c;
        this.charName = charName;
        this.charIcon = charIcon;
        this.charPortrait = charPortrait;
        this.charVision = charVision;
        this.charVisionIcon = charVisionIcon;
        this.charRarity = charRarity;
        this.charWeapon = charWeapon;
        this.charNation = charNation;
    }

    @Override
    public int getCount() {
        return charName.length;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);
        imageView.setImageResource(charIcon[position]);
        textView.setText(charName[position]);
        return convertView;
    }
}
