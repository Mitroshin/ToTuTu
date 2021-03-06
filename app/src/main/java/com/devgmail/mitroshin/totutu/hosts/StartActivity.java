package com.devgmail.mitroshin.totutu.hosts;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.devgmail.mitroshin.totutu.controllers.StartFragment;
import com.devgmail.mitroshin.totutu.util.DatabaseHelper;
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

// Хост для фрагмента StartFragment.java

public class StartActivity extends SingleFragmentActivity {

    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Создать базу данных если она еще не имеется.
        mDatabaseHelper = new DatabaseHelper(getApplicationContext());
        mDatabaseHelper.createDB();
    }

    @Override
    protected Fragment createFragment() {
        return new StartFragment();
    }
}
