
package ru.titov.taskmanagerserver.endpoint.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for projectResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="projectResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://project.endpoint.taskmanagerserver.titov.ru/}response"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="project" type="{http://project.endpoint.taskmanagerserver.titov.ru/}simpleProject" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectResponse", propOrder = {
    "project"
})
public class ProjectResponse
    extends Response
{

    protected SimpleProject project;

    /**
     * Gets the value of the project property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleProject }
     *     
     */
    public SimpleProject getProject() {
        return project;
    }

    /**
     * Sets the value of the project property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleProject }
     *     
     */
    public void setProject(SimpleProject value) {
        this.project = value;
    }

}
