package id.rofiqof.healthyqueue.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class SekizbitSwitch {
    private LinearLayout[] buttons;
    public int checkedIndex;
    private SekizbitSwitch that;

    private List<OnSelectedChangeListener> listeners = new ArrayList<OnSelectedChangeListener>();

    public void setOnChangeListener(OnSelectedChangeListener l) {
        this.listeners.clear();
        this.listeners.add(l);
    }

    public void setSelected(int index) {
        buttons[index].setSelected(true);
    }

    public void unSelected(int index) {
        buttons[index].setSelected(false);
    }

//    public void clearSelected() { buttons[0].clea}

//    public void setTextLeft(String text) {
//        buttons[0].setText(text);
//    }
//
//    public void setTextRight(String text) {
//        buttons[1].setText(text);
//    }


    public void setCheckedIndex(int checkedIndex) {
        this.checkedIndex = checkedIndex;
    }

    public int getCheckedIndex() {
        return this.checkedIndex;
    }

    public SekizbitSwitch(final View container) {

        that = this;

        buttons = new LinearLayout[2];
        int btnCounter = 0;
        for (int i = 0, j = 0; i < ((ViewGroup) container).getChildCount() && j < 2; i++) {
            View nextChild = ((ViewGroup) container).getChildAt(i);

            if (nextChild instanceof LinearLayout) {
                buttons[j] = (LinearLayout) nextChild;
                j++;
                btnCounter = j;
            }
        }


        View.OnClickListener customSwitchListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((LinearLayout) view) == buttons[0]) {
                    buttons[0].setSelected(true);
                    buttons[1].setSelected(false);
                    checkedIndex = 0;
                } else {
                    buttons[0].setSelected(false);
                    buttons[1].setSelected(true);
                    checkedIndex = 1;
                }

                for (OnSelectedChangeListener hl : listeners) {
                    hl.OnSelectedChange(that);
                }
            }
        };

        buttons[0].setOnClickListener(customSwitchListener);
        buttons[1].setOnClickListener(customSwitchListener);
    }


    public interface OnSelectedChangeListener extends EventListener {
        void OnSelectedChange(SekizbitSwitch sender);
    }

}
