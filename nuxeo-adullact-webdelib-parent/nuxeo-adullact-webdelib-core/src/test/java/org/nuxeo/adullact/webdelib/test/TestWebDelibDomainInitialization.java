/*
 * (C) Copyright 2013 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Benjamin JALON<bjalon@nuxeo.com>
 */
package org.nuxeo.adullact.webdelib.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.nuxeo.adullact.webdelib.WebDelibConstants.DOC_TYPE_DOMAIN;
import static org.nuxeo.adullact.webdelib.WebDelibConstants.DOMAIN_DESCRIPTION_VALUE;
import static org.nuxeo.adullact.webdelib.WebDelibConstants.DOMAIN_PATH;
import static org.nuxeo.adullact.webdelib.WebDelibConstants.DOMAIN_TITLE_VALUE;
import static org.nuxeo.adullact.webdelib.WebDelibConstants.STUDIO_SYMBOLIC_NAME;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features(CoreFeature.class)
@Deploy({ "org.nuxeo.ecm.platform.content.template", "nuxeo-adullact-webdelib-core", STUDIO_SYMBOLIC_NAME })
public class TestWebDelibDomainInitialization {

    @Inject
    CoreSession session;

    @Test
    public void shouldInitializeWebDelibDomain() throws Exception {
        DocumentModel domain = session.getDocument(new PathRef(DOMAIN_PATH));
        assertNotNull(domain);
        assertEquals(DOC_TYPE_DOMAIN, domain.getType());
        assertEquals(DOMAIN_TITLE_VALUE, domain.getTitle());
        assertEquals(DOMAIN_DESCRIPTION_VALUE, domain.getPropertyValue("dc:description"));

    }

}