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

package org.drools.workbench.screens.guided.dtable.client.wizard.column.pages;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import org.drools.workbench.screens.guided.dtable.client.wizard.column.plugins.BRLActionColumnPlugin;
import org.drools.workbench.screens.guided.rule.client.editor.RuleModeller;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.Heading;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import static org.drools.workbench.screens.guided.dtable.client.wizard.column.pages.common.DecisionTableColumnViewUtils.addWidgetToContainer;

@Dependent
@Templated
public class RuleModellerPageView implements IsElement,
                                             RuleModellerPage.View {

    @DataField("rule-modeller-container")
    private Div ruleModellerContainer;

    @DataField("description-heading")
    private Heading descriptionHeading;

    private RuleModellerPage page;

    @Inject
    public RuleModellerPageView(final Div ruleModellerContainer,
                                final @Named("h5") Heading descriptionHeading) {
        this.ruleModellerContainer = ruleModellerContainer;
        this.descriptionHeading = descriptionHeading;
    }

    @Override
    public void init(final RuleModellerPage page) {
        this.page = page;
    }

    @Override
    public void setupRuleModellerWidget(final RuleModeller ruleModeller) {
        addWidgetToContainer(ruleModeller,
                             ruleModellerContainer);
    }

    @Override
    public void setRuleModelerDescription(String description) {
        descriptionHeading.setTextContent(description);
    }
}
