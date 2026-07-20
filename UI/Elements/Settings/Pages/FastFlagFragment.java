package com.masterstrap.rbx.UI.Elements.Settings.Pages;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.masterstrap.rbx.App;
import com.masterstrap.rbx.Extensions.CustomUIComponents;
import com.masterstrap.rbx.Models.MethodPair;
import com.masterstrap.rbx.R;
import com.masterstrap.rbx.SettingsActivity;
import com.masterstrap.rbx.UI.ViewModels.Settings.LocalPreferencesViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.Objects;

/** FastFlag landing page: injection control and entry point to the full editor. */
public class FastFlagFragment extends Fragment {
    private LinearLayout content;
    private TextView description;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a_normal_page_fragment, container, false);
        content = view.findViewById(R.id.linear2);
        description = view.findViewById(R.id.textview_description);

        boolean isDark = Objects.equals(App.getMasterstrapSettings().getAppThemeInApp(), "dark");
        description.setTextColor(Color.parseColor(isDark ? "#D6D6D6" : "#282828"));
        App.setSavedFragmentActivity(requireActivity());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        description.setText(App.getTextLocale(App.getAppContext(), R.string.menu_fastflag_description));
        addEditorCard();
        addInjectionToggle();
        addPresetControls();
    }

    private void addEditorCard() {
        CustomUIComponents.ButtonResult editor = CustomUIComponents.addButton(
                requireContext(),
                App.getTextLocale(App.getAppContext(), R.string.menu_devicepreferences_help_title),
                App.getTextLocale(App.getAppContext(), R.string.menu_devicepreferences_help_description),
                content,
                "FlagsEditor",
                "internal_page"
        );
        editor.buttonOne.setOnClickListener(v -> {
            if (getActivity() instanceof SettingsActivity) {
                ((SettingsActivity) getActivity()).movePage("FlagsEditor");
            }
        });
        content.addView(editor.buttonView);
    }

    private void addInjectionToggle() {
        try {
            Method getter = LocalPreferencesViewModel.class.getMethod("isUseFastFlags");
            Method setter = LocalPreferencesViewModel.class.getMethod("setUseFastFlags", boolean.class);
            CustomUIComponents.ToggleResult toggle = CustomUIComponents.addToggle(
                    requireContext(),
                    App.getTextLocale(App.getAppContext(),
                            R.string.menu_devicepreferences_allowmanagelocalpreferences_title),
                    App.getTextLocale(App.getAppContext(),
                            R.string.menu_devicepreferences_allowmanagelocalpreferences_description),
                    content,
                    new MethodPair(getter, setter)
            );
            content.addView(toggle.toggleView);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("FastFlag injection preference is unavailable", e);
        }
    }

    private void addPresetControls() {
        addSection(R.string.menu_fastflag_section_graphics_quality);
        addDropdown("getPresetMsaaQuality", "setPresetMsaaQuality",
                R.string.menu_fastflag_preset_msaa_title,
                R.string.menu_fastflag_preset_msaa_description,
                new String[][] {
                        {"Automatic", "Automatic"}, {"Off / 1x", "Off"},
                        {"2x", "2x"}, {"4x", "4x"}, {"8x", "8x"}
                });
        addDropdown("getPresetFrmQuality", "setPresetFrmQuality",
                R.string.menu_fastflag_preset_frm_title,
                R.string.menu_fastflag_preset_frm_description,
                new String[][] {
                        {"Automatic", "Automatic"}, {"Level 1 (lowest)", "Lowest"},
                        {"Level 10 (balanced)", "Balanced"}, {"Level 21 (highest)", "Highest"}
                });
        addDropdown("getPresetRenderingMode", "setPresetRenderingMode",
                R.string.menu_fastflag_preset_rendering_mode_title,
                R.string.menu_fastflag_preset_rendering_mode_description,
                new String[][] {
                        {"Automatic", "Automatic"}, {"OpenGL", "OpenGL"}
                });
        addDropdown("getPresetDynamicResolution", "setPresetDynamicResolution",
                R.string.menu_fastflag_preset_dynamic_resolution_title,
                R.string.menu_fastflag_preset_dynamic_resolution_description,
                new String[][] {
                        {"Automatic", "Automatic"}, {"144p", "144p"}, {"240p", "240p"},
                        {"360p", "360p"}, {"480p", "480p"}, {"720p", "720p"},
                        {"1080p", "1080p"}
                });

        addSection(R.string.menu_fastflag_section_mobile_performance);
        addToggle("isPresetFpsBoost", "setPresetFpsBoost",
                R.string.menu_fastflag_preset_fps_boost_title,
                R.string.menu_fastflag_preset_fps_boost_description);
        addToggle("isPresetLowPolyMeshes", "setPresetLowPolyMeshes",
                R.string.menu_fastflag_preset_low_poly_title,
                R.string.menu_fastflag_preset_low_poly_description);
        addToggle("isPresetLowTextureMode", "setPresetLowTextureMode",
                R.string.menu_fastflag_preset_low_texture_title,
                R.string.menu_fastflag_preset_low_texture_description);
        addToggle("isPresetAndroidMeshCache", "setPresetAndroidMeshCache",
                R.string.menu_fastflag_preset_android_mesh_cache_title,
                R.string.menu_fastflag_preset_android_mesh_cache_description);
        addToggle("isPresetMeshPreloading", "setPresetMeshPreloading",
                R.string.menu_fastflag_preset_mesh_preloading_title,
                R.string.menu_fastflag_preset_mesh_preloading_description);
        addToggle("isPresetOptimizeParts", "setPresetOptimizeParts",
                R.string.menu_fastflag_preset_optimize_parts_title,
                R.string.menu_fastflag_preset_optimize_parts_description);

        addSection(R.string.menu_fastflag_section_visual_effects);
        addToggle("isPresetDisableShadows", "setPresetDisableShadows",
                R.string.menu_fastflag_preset_disable_shadows_title,
                R.string.menu_fastflag_preset_disable_shadows_description);
        addToggle("isPresetDisablePostFx", "setPresetDisablePostFx",
                R.string.menu_fastflag_preset_disable_postfx_title,
                R.string.menu_fastflag_preset_disable_postfx_description);
        addToggle("isPresetDisableGrass", "setPresetDisableGrass",
                R.string.menu_fastflag_preset_disable_grass_title,
                R.string.menu_fastflag_preset_disable_grass_description);
        addToggle("isPresetGraySky", "setPresetGraySky",
                R.string.menu_fastflag_preset_gray_sky_title,
                R.string.menu_fastflag_preset_gray_sky_description);
        addToggle("isPresetDisplayFps", "setPresetDisplayFps",
                R.string.menu_fastflag_preset_display_fps_title,
                R.string.menu_fastflag_preset_display_fps_description);
        addSection(R.string.menu_fastflag_presets_interface);
        addToggle("isPresetDisableGuiBlur", "setPresetDisableGuiBlur",
                R.string.menu_fastflag_preset_no_blur_title,
                R.string.menu_fastflag_preset_no_blur_description);
        addToggle("isPresetDisableDpiScale", "setPresetDisableDpiScale",
                R.string.menu_fastflag_preset_dpi_scale_title,
                R.string.menu_fastflag_preset_dpi_scale_description);
        addToggle("isPresetUnlimitedZoom", "setPresetUnlimitedZoom",
                R.string.menu_fastflag_preset_unlimited_zoom_title,
                R.string.menu_fastflag_preset_unlimited_zoom_description);
    }

    private void addSection(int titleResource) {
        CustomUIComponents.SectionResult section = CustomUIComponents.addSection(
                requireContext(), App.getTextLocale(App.getAppContext(), titleResource));
        content.addView(section.sectionContainer);
    }

    private void addToggle(String getterName, String setterName, int titleResource, int descriptionResource) {
        try {
            Method getter = LocalPreferencesViewModel.class.getMethod(getterName);
            Method setter = LocalPreferencesViewModel.class.getMethod(setterName, boolean.class);
            CustomUIComponents.ToggleResult toggle = CustomUIComponents.addToggle(
                    requireContext(),
                    App.getTextLocale(App.getAppContext(), titleResource),
                    App.getTextLocale(App.getAppContext(), descriptionResource),
                    content,
                    new MethodPair(getter, setter));
            content.addView(toggle.toggleView);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("FastFlag preset is unavailable: " + getterName, e);
        }
    }

    private void addDropdown(String getterName, String setterName, int titleResource,
                             int descriptionResource, String[][] options) {
        try {
            JSONArray values = new JSONArray();
            for (String[] option : options) {
                values.put(new JSONObject().put("label", option[0]).put("value", option[1]));
            }
            Method getter = LocalPreferencesViewModel.class.getMethod(getterName);
            Method setter = LocalPreferencesViewModel.class.getMethod(setterName, String.class);
            CustomUIComponents.DropdownResult dropdown = CustomUIComponents.addDropdown(
                    requireContext(),
                    App.getTextLocale(App.getAppContext(), titleResource),
                    App.getTextLocale(App.getAppContext(), descriptionResource),
                    content,
                    values,
                    new MethodPair(getter, setter));
            content.addView(dropdown.dropDownView);
        } catch (NoSuchMethodException | JSONException e) {
            throw new IllegalStateException("FastFlag preset is unavailable: " + getterName, e);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        content = null;
        description = null;
    }
}
