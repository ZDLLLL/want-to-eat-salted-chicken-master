package zjc.healthmanage.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.qiantao.coordinatormenu.CoordinatorMenu;

import java.util.ArrayList;

import zjc.healthmanage.R;
import zjc.healthmanage.activity.MainActivity;
import zjc.healthmanage.utils.HintPopupWindow;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvaluteFragment extends Fragment {
    private ImageView evalutefragment_iv;
    private View view;
    private MainActivity mainActivity;
    private HintPopupWindow hintPopupWindow;

    public EvaluteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_evalute, container, false);
        evalutefragment_iv=view.findViewById(R.id.evalutefragment_iv);
            evalutefragment_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mainActivity.mCoordinatorMenu.isOpened()) {
                        mainActivity.mCoordinatorMenu.closeMenu();
                    } else {
                        mainActivity.mCoordinatorMenu.openMenu();
                    }
                }
            });

        evalutefragment_iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                hintPopupWindow.showPopupWindow(view);
                Log.v("ZJC","新增用户！！！");
                return true;
            }
        });
        InitView();
        return view;
    }
    public void InitView() {

        //下面的操作是初始化弹出数据
        ArrayList<String> strList = new ArrayList<>();
        strList.add("选项item1");
        strList.add("选项item2");
        strList.add("选项item3");
        strList.add("选项item4");
        strList.add("选项item5");
        ArrayList<String> imageList = new ArrayList<>();
        ArrayList<View.OnClickListener> clickList = new ArrayList<>();
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "点击事件触发", Toast.LENGTH_SHORT).show();
            }
        };
        for (int i = 0; i < strList.size(); i++) {
            clickList.add(clickListener);
        }
        //hintPopupWindow.setBackgroundAlpha(getActivity(),1);
        //具体初始化逻辑看下面的图
        hintPopupWindow = new HintPopupWindow(getActivity(), strList, clickList);
    }
}



