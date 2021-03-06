/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.workbench.screens.guided.dtable.client.wizard.table.pages;

import java.util.List;

import org.uberfire.client.mvp.UberView;

/**
 * View and Presenter definitions for the Imports page
 */
public interface ImportsPageView
        extends
        UberView<ImportsPageView.Presenter> {

    interface Presenter {

        void addImport( String fqcn );

        boolean removeImport( String fqcn );

    }

    void setAvailableImports( List<String> availableImports );

    void setChosenImports( List<String> chosenImports );

}
