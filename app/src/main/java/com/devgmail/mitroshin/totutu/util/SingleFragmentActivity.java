package com.devgmail.mitroshin.totutu.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.devgmail.mitroshin.totutu.R;

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

//Абстрактный класс.
//Наследники данного класса должны просто вернуть экземпляр соответствующего фрагмента,
//чтобы начать выполнять функцию хоста данного фрагмента.
//Наличие данного класса упрощает реализацию активностей-хостингов.

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.container_frame_layout);
        // Вызов метода может произойти из-за изменения конфигурации,
        // в этом случае не нужно создавать новый экземпляр фрагмента
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.container_frame_layout, fragment).commit();
        }
    }
}
