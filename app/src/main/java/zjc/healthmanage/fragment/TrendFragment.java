package zjc.healthmanage.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.necer.calendar.Miui10Calendar;
import com.necer.entity.NDate;
import com.necer.listener.OnCalendarChangedListener;

import java.util.Arrays;
import java.util.List;

import zjc.healthmanage.R;
import zjc.healthmanage.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends Fragment {

    TextView tv_month;
    TextView tv_week;
    TextView tv_year;
    TextView tv_lunar;
    TextView tv_lunar_tg;
    public TrendFragment() {
        // Required empty public constructor
    }

    private final String[] weeks = {"周一", "周二", "周三", "周四", "周五", "周六", "周日",};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_trend, container, false);
        tv_month = view.findViewById(R.id.tv_month);
        tv_week = view.findViewById(R.id.tv_week);
        tv_year = view.findViewById(R.id.tv_year);
        tv_lunar = view.findViewById(R.id.tv_lunar);
        tv_lunar_tg =view. findViewById(R.id.tv_lunar_tg);

        List<String> pointList = Arrays.asList("2018-10-01", "2018-11-19", "2018-11-20", "2018-05-23", "2019-01-01");


        Miui10Calendar miui10Calendar = view.findViewById(R.id.miui10Calendar);
        miui10Calendar.setPointList(pointList);
        miui10Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarDateChanged(NDate date) {
                tv_year.setText(date.localDate.getYear() + "年");
                tv_month.setText(date.localDate.getMonthOfYear() + "月");
                tv_week.setText(weeks[date.localDate.getDayOfWeek() - 1]);
                tv_lunar.setText("农历" + date.lunar.lunarYearStr + "年 ");
                tv_lunar_tg.setText(date.lunar.lunarMonthStr + date.lunar.lunarDayStr + (TextUtils.isEmpty(date.lunarHoliday) ? "" : (" | " + date.lunarHoliday)) + (TextUtils.isEmpty(date.solarHoliday) ? "" : (" | " + date.solarHoliday)));

            }

            @Override
            public void onCalendarStateChanged(boolean isMonthSate) {

            }
        });
        return view;
    }

}
