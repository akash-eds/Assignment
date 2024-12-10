package com.newAssignment.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.newAssignment.core.service.PageService;

@Component(
    service = {Servlet.class},
    property = {
        "sling.servlet.paths=/bin/assessment/createpage",
        "sling.servlet.methods=GET,POST"
    }
)
public class PagePathServlet extends SlingAllMethodsServlet {

    @Reference
    private PageService pageService; 

    ResourceResolver resourceResolver;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Use POST method to create pages.");
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
       resourceResolver = request.getResourceResolver();
       pageService.createPage(resourceResolver,"page-1", "Page1");
       pageService.createPage(resourceResolver,"page-1", "Page1");

        
    }

    




}