package com.example.da08.airbnbserach;

import android.os.Build;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Da08 on 2017. 7. 27..
 */

public class StringUtil {
    public static void setHtmlText(TextView target, String text) {
    if(Build.VERSION.SDK_INT<Build.VERSION_CODES.N)

    {
        target.setText(Html.fromHtml(text));
    }else

    {
        target.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
    }
}
}
