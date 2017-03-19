package com.devgmail.mitroshin.totutu.hosts;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.devgmail.mitroshin.totutu.controllers.ListFragment;
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

// Хост для фрагмента ListFragment.java

public class ListActivity extends SingleFragmentActivity {

    public static final String EXTRA_DIRECTION_TYPE = "com.devgmail.mitroshin.totutu.direction_type";

    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }

    public static Intent newIntent (Context packageContext, String directionType) {
        Intent intent = new Intent(packageContext, ListActivity.class);
        intent.putExtra(EXTRA_DIRECTION_TYPE, directionType);
        return intent;
    }
}
