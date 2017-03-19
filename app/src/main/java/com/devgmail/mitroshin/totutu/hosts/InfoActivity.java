package com.devgmail.mitroshin.totutu.hosts;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.devgmail.mitroshin.totutu.controllers.InfoFragment;
import com.devgmail.mitroshin.totutu.model.Station;
import com.devgmail.mitroshin.totutu.util.SingleFragmentActivity;

/**
 Copyright 2017 Mitroshin Dmitry (mitroshin.develop@gmail.com)

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

// Хост для фрагмента InfoFragment.java

public class InfoActivity extends SingleFragmentActivity {

    public static final String EXTRA_STATION_OBJECT_TO_INFO =
            "com.devgmail.mitroshin.totutu.extra_station_object_to_info";

    @Override
    protected Fragment createFragment() {
        return new InfoFragment();
    }

    // Данный интент будет использоваться и для To и для From.
    public static Intent newIntent(Context packageContext, Station currentStation) {
        Intent intent = new Intent(packageContext, InfoActivity.class);
        intent.putExtra(EXTRA_STATION_OBJECT_TO_INFO, currentStation);
        return intent;
    }
}
