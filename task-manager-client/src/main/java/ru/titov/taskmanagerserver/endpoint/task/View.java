package ru.titov.taskmanagerserver.endpoint.task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for view complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="view"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taskOrderIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "view", propOrder = {
        "token",
        "taskOrderIndex"
})
public class View {

    protected String token;
    protected Integer taskOrderIndex;

    /**
     * Gets the value of the token property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the taskOrderIndex property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getTaskOrderIndex() {
        return taskOrderIndex;
    }

    /**
     * Sets the value of the taskOrderIndex property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setTaskOrderIndex(Integer value) {
        this.taskOrderIndex = value;
    }

}
