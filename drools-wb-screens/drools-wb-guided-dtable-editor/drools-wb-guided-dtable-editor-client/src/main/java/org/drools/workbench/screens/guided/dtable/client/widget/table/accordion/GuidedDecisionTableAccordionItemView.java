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

package org.drools.workbench.screens.guided.dtable.client.widget.table.accordion;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.Widget;
import org.jboss.errai.common.client.dom.Anchor;
import org.jboss.errai.common.client.dom.DOMTokenList;
import org.jboss.errai.common.client.dom.DOMUtil;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class GuidedDecisionTableAccordionItemView implements GuidedDecisionTableAccordionItem.View,
                                                             IsElement {

    @DataField("title")
    private Anchor title;

    @DataField("content")
    private Div content;

    private GuidedDecisionTableAccordionItem presenter;

    @Inject
    public GuidedDecisionTableAccordionItemView(final Anchor title,
                                                final Div content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public void init(final GuidedDecisionTableAccordionItem presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setTitle(final String title) {
        this.title.setTextContent(title);
    }

    @Override
    public void setContent(final Widget widget) {
        DOMUtil.appendWidgetToElement(content,
                                      widget);
    }

    @Override
    public void setItemId(final String itemId) {
        title.setHref("#" + itemId);
        content.setId(itemId);
    }

    @Override
    public void setOpen(final boolean isOpen) {
        final DOMTokenList classList = content.getClassList();
        final String opened = "in";

        if (isOpen) {
            classList.add(opened);
        } else {
            classList.remove(opened);
        }
    }

    @Override
    public void setParentId(final String parentId) {
        title.setAttribute("data-parent",
                           "#" + parentId);
    }
}
