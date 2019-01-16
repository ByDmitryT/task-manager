
package ru.titov.taskmanagerserver.endpoint.project;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projectListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projectListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://project.endpoint.taskmanagerserver.titov.ru/}response"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="projects" type="{http://project.endpoint.taskmanagerserver.titov.ru/}simpleProject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectListResponse", propOrder = {
    "projects"
})
public class ProjectListResponse
    extends Response
{

    @XmlElement(nillable = true)
    protected List<SimpleProject> projects;

    /**
     * Gets the value of the projects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the projects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProjects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleProject }
     * 
     * 
     */
    public List<SimpleProject> getProjects() {
        if (projects == null) {
            projects = new ArrayList<SimpleProject>();
        }
        return this.projects;
    }

}
