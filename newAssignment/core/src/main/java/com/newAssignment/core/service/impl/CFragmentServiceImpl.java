package com.newAssignment.core.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.ContentFragmentException;
import com.adobe.cq.dam.cfm.FragmentTemplate;
import com.newAssignment.core.service.CfService;

@Component(service = CfService.class)
public class CFragmentServiceImpl implements CfService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference private ResourceResolverFactory resolverFactory;

    @Override
    public void createCF() {
        logger.info("Running scheduled task");
        String cfModelPath = "/conf/newAssignment/settings/dam/cfm/models/ganesh";
        String cfFolder = "/content/dam/newAssignment/new-folder";
        String cfName="helo";

        Map<String, Object> authInfo = new HashMap<>();
        authInfo.put(ResourceResolverFactory.SUBSERVICE, "Akash");
        ResourceResolver resolver = null;


            try {
                resolver = resolverFactory.getServiceResourceResolver(authInfo);
            } catch (LoginException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Resource modelRes = resolver.getResource(cfModelPath);
            Resource fragmentFolderPath = resolver.getResource(cfFolder);

            FragmentTemplate template = modelRes.adaptTo(FragmentTemplate.class);
           

           

          
              

                String cfDescription = "Description for " + cfName;
                try {


                    ContentFragment fragment =
                            template.createFragment(fragmentFolderPath, cfName, cfDescription);



                } catch (ContentFragmentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               

            try {
                resolver.commit();
            } catch (PersistenceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }

  

   
}