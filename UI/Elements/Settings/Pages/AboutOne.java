package com.masterstrap.rbx.UI.Elements.Settings.Pages;

import android.content.Context;
import android.widget.LinearLayout;

import com.masterstrap.rbx.App;
import com.masterstrap.rbx.R;

public class AboutOne {
    public static void addEveryPresets(Context context, LinearLayout parentLayout, AboutOneFragment fragment) {
        fragment.addAccordionMenu(getTextLocale(context, R.string.common_masterstrap),
                getTextLocale(context, R.string.about_description),
                () -> addA(fragment, parentLayout), 1, parentLayout);
    }

    public static void addA(AboutOneFragment uiHelpers, LinearLayout parentLayout) {
        uiHelpers.addButton(App.getTextLocale(App.getAppContext(), R.string.about_github_repository_title),
                "github.com/Masterstrap", parentLayout, "https://github.com/Masterstrap", "link", 1);
        uiHelpers.addButton(App.getTextLocale(App.getAppContext(), R.string.about_join_discord_title),
                "Community, support and announcements", parentLayout, App.ProjectDiscordLink, "link", 1);
    }


    private static String getTextLocale(Context context, int resId) {
        return context.getString(resId);
    }
}
