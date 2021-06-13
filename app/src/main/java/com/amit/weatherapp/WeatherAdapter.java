package com.amit.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private WeatherList weatherList;
    private Context context;

    public WeatherAdapter(WeatherList weatherList, Context context) {
        this.weatherList = weatherList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rain.setText(String.valueOf(weatherList.getWeatherPojo().get(position).getRain()));
        Date date = new Date(weatherList.getWeatherPojo().get(position).getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d,yyyy", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = sdf.format(date);
        holder.time.setText(formattedDate);
        holder.wind.setText(String.valueOf(weatherList.getWeatherPojo().get(position).getWind()));
        holder.temp.setText(String.valueOf(weatherList.getWeatherPojo().get(position).getTemp()) + " C");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_weather,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return weatherList.getWeatherPojo().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView temp;
        public TextView rain;
        public TextView wind;
        public TextView time;

        public ViewHolder(View v) {
            super(v);
            temp = (TextView) v.findViewById(R.id.temperature);
            rain = (TextView) v.findViewById(R.id.rain_txt);
            wind = (TextView) v.findViewById(R.id.wind_txt);
            time = (TextView) v.findViewById(R.id.time);
        }
    }
}
