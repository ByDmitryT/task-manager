
package ru.titov.taskmanagerserver.endpoint.task;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://task.endpoint.taskmanagerserver.titov.ru/}response"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tasks" type="{http://task.endpoint.taskmanagerserver.titov.ru/}simpleTask" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskListResponse", propOrder = {
    "tasks"
})
public class TaskListResponse
    extends Response
{

    @XmlElement(nillable = true)
    protected List<SimpleTask> tasks;

    /**
     * Gets the value of the tasks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tasks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTasks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleTask }
     * 
     * 
     */
    public List<SimpleTask> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<SimpleTask>();
        }
        return this.tasks;
    }

}
