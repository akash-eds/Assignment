package com.newAssignment.core.service.impl;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;
import com.newAssignment.core.service.PageService;



@Component(service={PageService.class}, immediate = true)
public class PageServiceImpl implements PageService{

   

    @Override
    public Page createPage(ResourceResolver resourceResolver, String name, String title) {
       
        String parentPath = "/content/newAssignment/language-master/en_us";
        String templatePath = "/conf/newAssignment/settings/wcm/templates/sampletemplate";
        
        Page page=null;
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

        try {
            page = pageManager.create(parentPath, name, templatePath, title);
        } catch (WCMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return page;
    }

   

}
