package com.example.da08.airbnbserach;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Da08 on 2017. 7. 27..
 */

public class StringUtil {
    public static void setHtmlText(TextView target, String text) {
        target.setAllCaps(false);
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.N) {
            target.setText(Html.fromHtml(text),TextView.BufferType.SPANNABLE);  //  TextView.BufferType.SPANNABLE -> button의 색상을 바꿀때 설정값으로 해주는것
        }else {
            target.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY),TextView.BufferType.SPANNABLE);
        }
    }
}
