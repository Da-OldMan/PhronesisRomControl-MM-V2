#!/system/bin/sh
export PATH=/system/bin:$PATH


# notification
settings put system db_inkeffect_pekaka_memkiller_picker -16026407
settings put system memo_ram_text_color -1
settings put system quick_launch_text_color -14791048
settings put system quick_launch_background_color 00000000
settings put system expanded_header_bg_color -1643795
settings put system header_mod_clock_hours_color -14791048
settings put system header_mod_clock_minutes_color -14791048
settings put system header_mod_clock_seconds_color -14791048
settings put system date_header_color -13476476
settings put system expand_header_icon_color -14791048
settings put system quick_settings_panel_bg_color -1643795
settings put system toggle_buttons_background_color -657416
settings put system toggle_icon_on_color -14318119
settings put system toggle_icon_off_color -4930351
settings put system toggle_text_color -14791048
settings put system brightness_background_color -1643795
settings put system data_usage_view_bg_color -1643795
settings put system data_usage_color -14791048
settings put system quick_connect_bg_color -4340019
settings put system notification_background_color -328966
settings put system pulldown_text -14791048
settings put system edit_color -14791048
settings put system quickconnect_color -14791048

# lockscreen
settings put system kg_clock_hours_color -1
settings put system kg_clock_minutes_color -1
settings put system kg_clock_second_color -1
settings put system kg_date_color -1
settings put system next_alarm_color -1
settings put system carrier_color -1

# statusbar
settings put system statusbar_wifi_color -1
settings put system statusbar_signal_color -1
settings put system statusbar_data_color -1
settings put system statusbar_icon_color -1
settings put system battery_bar_color -1
settings put system killprocess_carrier_txt_color -1
settings put system network_traffic_color -1

sleep 3

pkill com.android.systemui