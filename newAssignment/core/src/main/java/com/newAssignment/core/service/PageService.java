package com.newAssignment.core.service;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;

public interface PageService{

    Page createPage(ResourceResolver resourceResolver, String name, String title);

    

}





