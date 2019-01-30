
package ru.titov.taskmanagerserver.endpoint.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for userListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userListResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://user.endpoint.taskmanagerserver.titov.ru/}response"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="users" type="{http://user.endpoint.taskmanagerserver.titov.ru/}simpleUser" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userListResponse", propOrder = {
    "users"
})
public class UserListResponse
    extends Response
{

    @XmlElement(nillable = true)
    protected List<SimpleUser> users;

    /**
     * Gets the value of the users property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the users property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleUser }
     * 
     * 
     */
    public List<SimpleUser> getUsers() {
        if (users == null) {
            users = new ArrayList<SimpleUser>();
        }
        return this.users;
    }

}
