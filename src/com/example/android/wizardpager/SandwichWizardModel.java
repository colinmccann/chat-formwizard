/*
 * Copyright 2012 Roman Nurik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.wizardpager;

import com.example.android.wizardpager.wizard.model.AbstractWizardModel;
import com.example.android.wizardpager.wizard.model.BranchPage;
import com.example.android.wizardpager.wizard.model.CustomerInfoPage;
import com.example.android.wizardpager.wizard.model.MultipleFixedChoicePage;
import com.example.android.wizardpager.wizard.model.PageList;
import com.example.android.wizardpager.wizard.model.SingleFixedChoicePage;

import android.content.Context;

public class SandwichWizardModel extends AbstractWizardModel {
    public SandwichWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(
                new CustomerInfoPage(this, "Caregiver information")
                .setRequired(true),
        		
                new BranchPage(this, "Form choice")
                		.addBranch("Household Checklist",
                                new SingleFixedChoicePage(this, "Gender")
                                        .setChoices("Male", "Female")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Relationship to child")
                                        .setChoices("Mother", "Father", "Sister", "Brother",
                                                "Aunt", "Uncle", "Grandmother", "Grandfather", "Other")
                                        .setRequired(true),

                                new MultipleFixedChoicePage(this, "Education completed")
                                        .setChoices("Primary school", "Secondary school", "College", "University",
                                                "Diploma", "Other"),

                                new BranchPage(this, "Are you currently employed?")
                                        .addBranch("Yes",
                                                new SingleFixedChoicePage(this, "Level of employment")
                                                        .setChoices("Full time", "Part time"))
                                        .addBranch("No"))

                        .addBranch("Household Services",
                                new SingleFixedChoicePage(this, "Visit type")
                                        .setChoices("Scheduled", "Emergency")
                                        .setValue("Scheduled"),

                                new MultipleFixedChoicePage(this, "What are we going to talk about today?")
                                        .setChoices("Child care", "Pre-natal care", "HIV care",
                                                "Other")
                        )

                        .setRequired(true)

        );
    }
}
