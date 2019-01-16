
package ru.titov.taskmanagerserver.endpoint.task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://task.endpoint.taskmanagerserver.titov.ru/}response"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="task" type="{http://task.endpoint.taskmanagerserver.titov.ru/}simpleTask" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskResponse", propOrder = {
    "task"
})
public class TaskResponse
    extends Response
{

    protected SimpleTask task;

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleTask }
     *     
     */
    public SimpleTask getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleTask }
     *     
     */
    public void setTask(SimpleTask value) {
        this.task = value;
    }

}
