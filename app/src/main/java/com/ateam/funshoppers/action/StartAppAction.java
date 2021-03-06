/*
 *
 *  Copyright (c) 2016 SameBits UG. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ateam.funshoppers.action;

import android.content.Context;
import android.content.Intent;

import com.ateam.funshoppers.R;
import com.ateam.funshoppers.model.NotificationAction;


/**
 * Created by vitas on 03/01/16.
 */
public class StartAppAction extends NoneAction {


    public StartAppAction(String param, NotificationAction notification) {
        super(param, notification);
    }

    @Override
    public String execute(Context context) {
        try {
            Intent newIntent = new Intent(Intent.ACTION_MAIN);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            newIntent.setPackage(param);
            context.startActivity(newIntent);
        } catch (Exception e) {
            return context.getString(R.string.action_start_application_error);
        }
        return super.execute(context);
    }

    @Override
    public boolean isParamRequired() {
        return true;
    }

    @Override
    public String toString() {
        return "StartAppAction, app_package: " + param;
    }
}
