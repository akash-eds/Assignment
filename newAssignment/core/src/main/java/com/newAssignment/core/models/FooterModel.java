package com.newAssignment.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FooterModel {

    @ValueMapValue
    private String fileReference;
    @ValueMapValue
    private String description;
    @ValueMapValue
    private String title;

     @ChildResource  
    private List<Link> actions;

  
    public String getFileReference() {
        return fileReference;
    }


    public String getDescription() {
        return description;
    }


    public String getTitle() {
        return title;
    }


    public List<Link> getActions() {
        return actions;
    }


    @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public static class Link {
    @ValueMapValue
    private String descriptionButton;
    @ValueMapValue
    private String linkTarget;
    @ValueMapValue
    private boolean openInNewTab;
    public String getDescriptionButton() {
        return descriptionButton;
    }
    public String getLinkTarget() {
        return linkTarget;
    }
    public boolean isOpenInNewTab() {
        return openInNewTab;
    }


       
    }
    

}