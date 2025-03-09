package org.da1.labormanagementbackend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import java.util.*;


@Entity
@Getter
@Setter
public class Resume extends BaseModel{
    private String resumeFile;
    private String summary;
    private List<String> skills;
    private String Experience;
}
