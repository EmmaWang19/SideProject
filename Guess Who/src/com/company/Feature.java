package com.company;

import java.util.ArrayList;
import java.util.List;

public class Feature {

    private String featureName;
    private List<String> featureOptions = new ArrayList<>();

    //Constructor
    public Feature(String featureName, List<String> featureOptions){
        this.featureName=featureName;
        this.featureOptions=featureOptions;
    }

    //Getter

    public String getFeatureName() {
        return featureName;
    }

    public List<String> getFeatureOption() {
        return featureOptions;
    }
}
